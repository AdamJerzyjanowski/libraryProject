const navSlide = () =>{
    const burger = document.querySelector('.burger');
    const nav    = document.querySelector('.navbar-list');
    const navLinks = document.querySelector('.navbar-list');
    burger.addEventListener('click', () => {
        nav.classList.toggle('nav-active');
        burger.classList.toggle('toggle');
        navLinks.forEach((link,index)=> {
            if(link.style.animation){
                link.style.animation = '';
            }else{
                link.style.animation = 'navLinkFade 0.5s else forwards ${index/7+0.3}';
            }
        });

    });

}
navSlide();