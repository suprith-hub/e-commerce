import React, { useState } from "react";
import AliceCarousel from "react-alice-carousel";
import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";
import { Button, Typography } from "@mui/material";
import KeyboardArrowLeftIcon from "@mui/icons-material/KeyboardArrowLeft";

const responsive = {
  0: { items: 1 },
  568: { items: 3 },
  1024: { items: 5.5 },
};

const HomeSectionCarousel = ({
  items,
  sectionName,
}: {
  items: any;
  sectionName: string;
}) => {
  const [activeIndex, setActiveIndex] = useState(0);

  const slidePrev = () => {
    setActiveIndex((prevIndex) => Math.max(prevIndex - 1, 0));
  };

  const slideNext = () => {
    setActiveIndex((prevIndex) => prevIndex + 1);
  };

  const syncActiveIndex = (e: any) => {
    setActiveIndex(e.item);
  };

  return (
    <div className="border">
      <div className="px-6">
        <Typography
          sx={{ fontSize: "32px", fontWeight: 500, color: "#111927" }}
        >
          {sectionName}
        </Typography>
      </div>
      <div className="relative p-5">
        <AliceCarousel
          items={items.map((product: any, index: number) => (
            <HomeSectionCard product={product} key={index} />
          ))}
          responsive={responsive}
          controlsStrategy="alternate"
          disableButtonsControls
          activeIndex={activeIndex} // Controlled by React state
          onSlideChanged={syncActiveIndex} // Sync internal carousel state with React state
        />
        {activeIndex < items.length - 5 && (
          <Button
            variant="contained"
            className="z-50"
            sx={{
              position: "absolute",
              top: "8rem",
              right: "0px",
              transform: "translateX(50%) rotate(90deg)",
            }}
            onClick={slideNext}
          >
            <KeyboardArrowLeftIcon sx={{ transform: "rotate(90deg)" }} />
          </Button>
        )}

        {activeIndex > 0 && (
          <Button
            variant="contained"
            className="z-50"
            sx={{
              position: "absolute",
              top: "8rem",
              left: "0px",
              transform: "translateX(50%) rotate(90deg)",
            }}
            onClick={slidePrev}
          >
            <KeyboardArrowLeftIcon sx={{ transform: "rotate(-90deg)" }} />
          </Button>
        )}
      </div>
    </div>
  );
};

export default HomeSectionCarousel;
