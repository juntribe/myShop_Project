<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2021/05/25
  Time: 3:43 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing:border-box;
    }

    /* Slideshow container */
    .slideshow-container {
        max-width: 1350px;
        max-height: 750px;
        position: relative;
        margin: auto;
    }
    .slideshow-container .mySlides img {
        height: 350px;
    }

    /* Hide the images by default */
    .mySlides {
        display: none;
    }

    /* Next & previous buttons */
    /*.prev, .next {*/
    /*    cursor: pointer;*/
    /*    position: absolute;*/
    /*    top: 50%;*/
    /*    width: 100%;*/
    /*    margin-top: -22px;*/
    /*    padding: 16px;*/
    /*    color: black;*/
    /*    font-weight: bold;*/
    /*    font-size: 18px;*/
    /*    transition: 0.6s ease;*/
    /*    border-radius: 0 3px 3px 0;*/
    /*    user-select: none;*/
    /*}*/

    /*!* Position the "next button" to the right *!*/
    /*.next {*/
    /*    right: 0;*/
    /*    border-radius: 3px 0 0 3px;*/
    /*}*/

    /*!* On hover, add a black background color with a little bit see-through *!*/
    /*.prev:hover, .next:hover {*/
    /*    background-color: rgba(0,0,0,0.8);*/
    /*}*/

    /* Caption text */
    .text {
        color: #f2f2f2;
        font-size: 15px;
        padding: 8px 12px;
        position: absolute;
        bottom: 8px;
        width: 100%;
        text-align: center;
    }

    /* Number text (1/3 etc) */
    .numbertext {
        color: #f2f2f2;
        font-size: 12px;
        padding: 8px 12px;
        position: absolute;
        top: 0;
    }

    /* The dots/bullets/indicators */
    .dot {
        cursor: pointer;
        height: 15px;
        width: 15px;
        margin: 0 2px;
        background-color: #bbb;
        border-radius: 50%;
        display: inline-block;
        transition: background-color 0.6s ease;
    }

    .active, .dot:hover {
        background-color: #717171;
    }

    /* Fading animation */
    .fade {
        -webkit-animation-name: fade;
        -webkit-animation-duration: 1.5s;
        animation-name: fade;
        animation-duration: 1.5s;
    }

    @-webkit-keyframes fade {
        from {opacity: .4}
        to {opacity: 1}
    }

    @keyframes fade {
        from {opacity: .4}
        to {opacity: 1}
    }

</style>
<script type="text/javascript">
    var slideIndex = 0; //slide index

    // HTML 로드가 끝난 후 동작
    window.onload=function(){
        showSlides(slideIndex);

        // Auto Move Slide
        var sec = 3000;
        setInterval(function(){
            slideIndex++;
            showSlides(slideIndex);

        }, sec);
    }


    // Next/previous controls
    function moveSlides(n) {
        slideIndex = slideIndex + n
        showSlides(slideIndex);
    }

    // Thumbnail image controls
    function currentSlide(n) {
        slideIndex = n;
        showSlides(slideIndex);
    }

    function showSlides(n) {

        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        var size = slides.length;

        if ((n+1) > size) {
            slideIndex = 0; n = 0;
        }else if (n < 0) {
            slideIndex = (size-1);
            n = (size-1);
        }

        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }

        slides[n].style.display = "block";
        dots[n].className += " active";
    }

</script>
<meta name="viewport" content="width=device-width,initial-scale=1">
<head>
    <title>Title</title>
</head>
<body>

<div class="slideshow-container">

    <!-- Full-width images with number and caption text -->
    <div class="mySlides fade">
        <div class="numbertext">1 / 6</div>
        <img src="https://divisare-res.cloudinary.com/images/f_auto,q_auto,w_800/v1491425456/ltekybkstiyl7faumrsq/acne-studios-acne-studio-potsdamer-strasse.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">2 / 6</div>
        <img src="https://divisare-res.cloudinary.com/images/f_auto,q_auto,w_800/v1491425435/hwxwxqxfwo4htfgqksbu/acne-studios-acne-studio-potsdamer-strasse.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">3 / 6</div>
        <img src="https://divisare-res.cloudinary.com/images/f_auto,q_auto,w_800/v1491425448/rnelglmoujifzlbzykxw/acne-studios-acne-studio-potsdamer-strasse.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">4 / 6</div>
        <img src="https://divisare-res.cloudinary.com/images/f_auto,q_auto,w_800/v1491425434/coct9kmra7uhmeu4cxto/acne-studios-acne-studio-potsdamer-strasse.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">5 / 6</div>
        <img src="https://divisare-res.cloudinary.com/images/f_auto,q_auto,w_800/v1491425440/xacfj7abitmifeyciiia/acne-studios-acne-studio-potsdamer-strasse.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">6 / 6</div>
        <img src="https://divisare-res.cloudinary.com/images/f_auto,q_auto,w_800/v1491425434/cqxjhpdmepxto0nudsok/acne-studios-acne-studio-potsdamer-strasse.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
    </div>

    <!-- Next and previous buttons -->
    <!--    <a class="prev" onclick="moveSlides(-1)">&#10094;</a>-->
    <!--    <a class="next" onclick="moveSlides(1)">&#10095;</a>-->
</div>
<br/>

<!-- The dots/circles -->
<div style="text-align:center">
    <span class="dot" onclick="currentSlide(0)"></span>
    <span class="dot" onclick="currentSlide(1)"></span>
    <span class="dot" onclick="currentSlide(2)"></span>
    <span class="dot" onclick="currentSlide(3)"></span>
    <span class="dot" onclick="currentSlide(4)"></span>
    <span class="dot" onclick="currentSlide(5)"></span>
</div>

</body>
</html>
