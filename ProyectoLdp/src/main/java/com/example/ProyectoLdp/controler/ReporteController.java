package com.example.ProyectoLdp.controler;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
public class ReporteController {

    private final DataSource dataSource;

    public ReporteController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/api/reportes/reservas")
    public void exportarReporteReservas(HttpServletResponse response) throws Exception {
    	ClassPathResource resource = new ClassPathResource("/reportes/reporte_reservas.jasper");

        InputStream jasperStream = resource.getInputStream();

        try (Connection conn = dataSource.getConnection()) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, new HashMap<>(), conn);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=ReporteReservas.pdf");

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        }
    }
}