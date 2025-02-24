// scripts.js
// Countdown Timer
const conferenceDate = new Date('2025-03-30T00:00:00'); // Updated to March 30, 2025

function updateCountdown() {
  const now = new Date();
  const timeDifference = conferenceDate.getTime() - now.getTime();

  if (timeDifference <= 0) {
    document.getElementById('countdown-timer').innerHTML = "The conference has started!";
    return;
  }

  const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
  const hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  const minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
  const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);

  document.getElementById('days').textContent = days.toString().padStart(2, '0');
  document.getElementById('hours').textContent = hours.toString().padStart(2, '0');
  document.getElementById('minutes').textContent = minutes.toString().padStart(2, '0');
  document.getElementById('seconds').textContent = seconds.toString().padStart(2, '0');
}

setInterval(updateCountdown, 1000);
updateCountdown();

// Dynamic Bar Chart
const dynamicContent = document.getElementById('dynamic-content');
const ctx = document.getElementById('myChart').getContext('2d');

const data = [
  { content: "12,000 - Editorial Team", graphData: [12000, 26000, 10000, 6000] },
  { content: "26,000 - Journals Published", graphData: [26000, 18000, 23000, 10000] },
  { content: "10 - Authors Collaborated", graphData: [10000, 12000, 6000, 18000] },
  { content: "600 - Conferences Organized", graphData: [6000, 10000, 26000, 12000] }
];

const backgroundColors = [
  'rgba(255, 99, 132, 0.6)', // Red
  'rgba(54, 162, 235, 0.6)', // Blue
  'rgba(255, 206, 86, 0.6)', // Yellow
  'rgba(75, 192, 192, 0.6)'  // Green
];

let currentIndex = 0;

const myChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ['EDITORIAL TEAM', 'JOURNALS', 'AUTHORS', 'CONFERENCE PUBLISHED'],
    datasets: [{
      data: data[currentIndex].graphData,
      backgroundColor: backgroundColors,
      borderWidth: 1
    }]
  },
  options: {
    responsive: true,
    plugins: {
      legend: { display: false } // Hide the legend
    },
    scales: {
      x: { display: false }, // Hide x-axis
      y: { display: false, beginAtZero: true } // Hide y-axis
    },
    barPercentage: 1, // Controls the relative width of the bars (0 to 1)
    categoryPercentage: 1 // Controls the space between categories (0 to 1)
  }
});

function updateContentAndGraph() {
  dynamicContent.innerHTML = `<strong>${data[currentIndex].content}</strong>`;
  myChart.data.datasets[0].data = data[currentIndex].graphData;
  myChart.update();
  currentIndex = (currentIndex + 1) % data.length;
}

setInterval(updateContentAndGraph, 3000);
updateContentAndGraph();

// Smooth Scrolling
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
  anchor.addEventListener('click', function (e) {
    e.preventDefault();
    document.querySelector(this.getAttribute('href')).scrollIntoView({
      behavior: 'smooth'
    });
  });
});

// Load Speakers Dynamically
fetch('speakers.json')
  .then(response => response.json())
  .then(data => {
    const speakersGrid = document.getElementById('speakersGrid');
    data.forEach(speaker => {
      speakersGrid.innerHTML += `
        <div class="speaker">
          <img src="${speaker.photo}" alt="${speaker.name}">
          <h3>${speaker.name}</h3>
          <p><strong>${speaker.designation}</strong></p>
          <p>${speaker.bio}</p>
        </div>
      `;
    });
  });

// Form Validation
const contactForm = document.getElementById('contactForm');
contactForm.addEventListener('submit', (e) => {
  e.preventDefault();
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;
  const message = document.getElementById('message').value;

  if (name && email && message) {
    alert('Form submitted successfully!');
    contactForm.reset();
  } else {
    alert('Please fill out all fields.');
  }
});

// Dark Mode Toggle
const darkModeToggle = document.getElementById('dark-mode-toggle');
const body = document.body;

// Check for saved user preference
const savedTheme = localStorage.getItem('theme');
if (savedTheme === 'dark') {
  body.classList.add('dark-mode');
  darkModeToggle.innerHTML = '<i class="fas fa-sun"></i>'; // Sun icon for light mode
}

// Toggle dark mode
darkModeToggle.addEventListener('click', () => {
  body.classList.toggle('dark-mode');
  const isDarkMode = body.classList.contains('dark-mode');

  // Save user preference
  localStorage.setItem('theme', isDarkMode ? 'dark' : 'light');

  // Update toggle icon
  darkModeToggle.innerHTML = isDarkMode ? '<i class="fas fa-sun"></i>' : '<i class="fas fa-moon"></i>';
});