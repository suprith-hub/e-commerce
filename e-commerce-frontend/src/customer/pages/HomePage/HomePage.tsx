import React from "react";
import HomeCarousel from "../../components/HomeCarousel/HomeCarousel";
import HomeSectionCarousel from "../../components/HomeSectionCarousel/HomeSectionCarousel";
import { mens_kurta } from "../../data/data";

const HomePage = () => {
  return (
    <div>
      <HomeCarousel />
      <div className="space-y-10 py-20 flex flex-col">
        <HomeSectionCarousel items={mens_kurta} sectionName={"Men's Kurta"} />
        <HomeSectionCarousel items={mens_kurta} sectionName={"Men's Shoes"}/>
        <HomeSectionCarousel items={mens_kurta} sectionName={"Men's Shirt"}/>
        <HomeSectionCarousel items={mens_kurta} sectionName={"Women's Saree"}/>
        <HomeSectionCarousel items={mens_kurta} sectionName={"Women's Dress"}/>
      </div>
    </div>
  );
};

export default HomePage;
