const sortOptions = [
  { name: "Most Popular", href: "#", current: false },
  { name: "Best Rating", href: "#", current: false },
  { name: "Newest", href: "#", current: false },
  { name: "Price: Low to High", href: "#", current: false },
  { name: "Price: High to Low", href: "#", current: false },
];
const subCategories = [
  { name: "Totes", href: "#" },
  { name: "Backpacks", href: "#" },
  { name: "Travel Bags", href: "#" },
  { name: "Hip Bags", href: "#" },
  { name: "Laptop Sleeves", href: "#" },
];
const filters = [
  {
    id: "color",
    name: "Color",
    options: [
      { value: "white", label: "White", checked: false },
      { value: "beige", label: "Beige", checked: false },
      { value: "blue", label: "Blue", checked: false },
      { value: "brown", label: "Brown", checked: false },
      { value: "green", label: "Green", checked: false },
      { value: "purple", label: "Purple", checked: false },
    ],
  },
  {
    id: "category",
    name: "Category",
    options: [
      { value: "new-arrivals", label: "New Arrivals", checked: false },
      { value: "sale", label: "Sale", checked: false },
      { value: "travel", label: "Travel", checked: false },
      { value: "organization", label: "Organization", checked: false },
      { value: "accessories", label: "Accessories", checked: false },
    ],
  },
  {
    id: "size",
    name: "Size",
    options: [
      { value: "2l", label: "2L", checked: false },
      { value: "6l", label: "6L", checked: false },
      { value: "12l", label: "12L", checked: false },
      { value: "18l", label: "18L", checked: false },
      { value: "20l", label: "20L", checked: false },
      { value: "40l", label: "40L", checked: false },
    ],
  },
];

const singleFilters = [
  {
    id: "price",
    name: "Price",
    options: [
      { value: "159-399", label: "₹159 To ₹399", checked: false },
      { value: "399-999", label: "₹399 To ₹999", checked: false },
      { value: "999-1999", label: "₹999 To ₹1999", checked: false },
      { value: "1999-2999", label: "₹1999 To ₹2999", checked: false },
      { value: "2999-4999", label: "₹2999 To ₹4999", checked: false },
    ],
  },
  {
    id: "discount",
    name: "Discount",
    options: [
      { value: "10", label: "10% and Above", checked: false },
      { value: "20", label: "20% and Above", checked: false },
      { value: "30", label: "30% and Above", checked: false },
      { value: "40", label: "40% and Above", checked: false },
      { value: "50", label: "50% and Above", checked: false },
      { value: "60", label: "60% and Above", checked: false },
      { value: "70", label: "70% and Above", checked: false },
      { value: "80", label: "80% and Above", checked: false },
    ],
  },
];

export { sortOptions, subCategories, filters, singleFilters };
