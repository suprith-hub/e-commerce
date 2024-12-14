import { Box, Grid2, Rating, Typography } from "@mui/material";
import React from "react";

const ProductReviewCard = ({ review }: { review: any }) => {
  if (review == null) {
    return <></>;
  }
  return (
    <div>
      <Box sx={{ display: "flex", flexDirection: "row" }}>
        <Box
          sx={{
            width: 2,
            height: 2,
            borderRadius: "50%",
            backgroundColor: "purple",
            color: "white",
          }}
        />
        <Box>
          <Typography
            sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
          >
            {review.reviewerName}
          </Typography>
          <p>{review.date}</p>
          <Rating name="read-only" value={review.rating} readOnly />
          <p>{review.review}</p>
        </Box>
      </Box>
    </div>
  );
};

export default ProductReviewCard;
