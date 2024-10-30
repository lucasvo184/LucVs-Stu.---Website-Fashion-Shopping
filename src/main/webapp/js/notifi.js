let notifications = document.querySelector('.notifications');
    let success = document.getElementById('success');
    let error = document.getElementById('error');
    let warning = document.getElementById('warning');
    let info = document.getElementById('info');
    
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
    warning.onclick = function(){
        let type = 'warning';
        let icon = 'fa-solid fa-triangle-exclamation';
        let title = 'Warning';
        let text = 'This is a warning toast.';
        createToast(type, icon, title, text);
    }
    info.onclick = function(){
        let type = 'info';
        let icon = 'fa-solid fa-circle-info';
        let title = 'Info';
        let text = 'This is a info toast.';
        createToast(type, icon, title, text);
    }