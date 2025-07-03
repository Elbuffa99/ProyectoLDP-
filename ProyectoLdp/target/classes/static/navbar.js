// navbar.js

function loadUserInfoAndProtectRoute() {
  const username = localStorage.getItem('username');
  const role = localStorage.getItem('role');

  if (!username || !role) {
    window.location.href = '/login';
    return;
  }

  const usernameSpan = document.getElementById('loggedInUsername');
  if (usernameSpan) {
    usernameSpan.textContent = `${username}`;
  }

  const roleSpan = document.getElementById('loggedInRole');
  if (roleSpan) {
    roleSpan.textContent = role;
  }

  // 🔒 ocultar enlaces para recepcionista
  if (role !== 'admin') {
    const mesas = document.getElementById('linkMesas');
    const horas = document.getElementById('linkHoras');
    if (mesas) mesas.style.display = 'none';
    if (horas) horas.style.display = 'none';
  }
}


function setupLogout() {
  const logoutLink = document.getElementById('logoutLink');
  const logoutButton = document.getElementById('logoutButton');
  const logout = () => {
    localStorage.clear();
    window.location.href = '/logout';
  };

  if (logoutLink) logoutLink.addEventListener('click', (e) => { e.preventDefault(); logout(); });
  if (logoutButton) logoutButton.addEventListener('click', logout);
}
	
function setupDropdown() {
  const dropdown = document.getElementById('userDropdownContent');
  const trigger = document.getElementById('userInfoDropdown');

  if (trigger && dropdown) {
    trigger.addEventListener('click', (e) => {
      e.stopPropagation();
      dropdown.classList.toggle('show');
    });

    window.addEventListener('click', (e) => {
      if (!trigger.contains(e.target)) {
        dropdown.classList.remove('show');
      }
    });
  }
  console.log("navbar.js cargado correctamente");
}

