const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});

//Notification
let notifications = document.querySelector('.notifications');
    let success = document.getElementById('btn-sign-up');
    let error = document.getElementById('error');
    
    function createToast(type, icon, title, text){
        let newToast = document.createElement('div');
        newToast.innerHTML = `
            <div class="toast ${type}">
                <i class="${icon}"></i>
                <div class="content">
                    <div class="title">${title}</div>
                    <span>${text}</span>
                </div>
                <i class="fa-solid fa-xmark" onclick="(this.parentElement).remove()"></i>
            </div>`;
        notifications.appendChild(newToast);
        newToast.timeOut = setTimeout(
            ()=>newToast.remove(), 1500
        )
    }
    success.onclick = function(){
        let type = 'success';
        let icon = 'fa-solid fa-circle-check';
        let title = 'Thành công!';
        let text = 'Bạn đã đăng ký thành công';
        createToast(type, icon, title, text);
    }
    error.onclick = function(){
        let type = 'error';
        let icon = 'fa-solid fa-circle-exclamation';
        let title = 'Lỗi!';
        let text = 'Có sự cố đã xảy ra';
        createToast(type, icon, title, text);
    }