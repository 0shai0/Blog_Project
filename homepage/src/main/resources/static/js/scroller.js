document.addEventListener('DOMContentLoaded', function () {
    // Wait for the DOM to be fully loaded
  
    // Scroll to the next body on scroll
    var loading = document.getElementById("loading");
    let currentBody = 1;


    


    loading.addEventListener("animationend", function () {
        loading.style.display = "none";
        
  
        // Show other elements
        document.getElementById("body2").style.opacity = "1";
        document.getElementById("body3").style.opacity = "1";
        document.getElementById("body4").style.opacity = "1";
        document.getElementById("body5").style.opacity = "1";
        // Add more elements as needed
  
        // Enable scrolling
        document.body.style.overflow = "auto";
      });
    


  
    window.addEventListener('wheel', function (event) {
      if (event.deltaY > 0) {
        // Scrolling down
        currentBody++;
      } else {
        // Scrolling up
        currentBody--;
      }
  
      // Ensure currentBody is within the desired range
      currentBody = Math.max(1, Math.min(currentBody, 5));
  
      // Scroll to the corresponding body
      const bodyElement = document.getElementById(`body${currentBody}`);
      bodyElement.scrollIntoView({ behavior: 'smooth' });
    });
});