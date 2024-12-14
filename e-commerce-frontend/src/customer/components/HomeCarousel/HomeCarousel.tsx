import React from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";
import { data } from "./data";

const responsive = {
  0: { items: 1 },
  568: { items: 2 },
  1024: { items: 3 },
};

const HomeCarousel = () => {
  const items = data.map((item) => (
    <img
      className="cursor-pointer"
      src={item.image}
      alt={item.path}
      role="presentation"
    />
  ));

  return (
    <AliceCarousel
      mouseTracking
      items={items}
      responsive={responsive}
      controlsStrategy="alternate"
      disableButtonsControls
      autoPlay
      autoPlayInterval={2000}
      infinite
    />
  );
};

export default HomeCarousel;
