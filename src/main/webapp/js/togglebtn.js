const toggleBtn = document.querySelector('.toggle-btn')  
const toggleBtnIcon = document.querySelector('.toggle-btn i')  
const dropDownMenu = document.querySelector('.drop-menu') 

toggleBtn.onclick = function() {
    dropDownMenu.classList.toggle('open')
    const isOpen = dropDownMenu.classList.contains('open')

    // Đổi class theo trạng thái của menu
    toggleBtnIcon.className = isOpen
        ? 'fa-solid fa-xmark'  
        : 'fa-solid fa-bars'  
}
