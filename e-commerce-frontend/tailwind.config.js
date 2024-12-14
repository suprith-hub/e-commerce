/** @type {import('tailwindcss').Config} */
export default {
  content: ["./src/**/*.{html,js,tsx,jsx}", "./public/index.html"],
  theme: {
    extend: {},
  },
  plugins: [require("@tailwindcss/forms")],
};
