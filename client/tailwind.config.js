/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'custom-blue': 'rgba(45, 55, 72, 1)', 
        'custom-light-blue': '#CEE6FC',
        'custom-light-btn': '#60A3D9',

      },
    },
  },
  plugins: [],
}