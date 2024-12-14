import { Box, Button, Grid, Grid2, MenuItem, Typography } from "@mui/material";
import React from "react";

const Footer = () => {
  return (
    <div>
      <Grid2
        className="bg-black text-center text-white mt-10"
        container
        sx={{ bgcolor: "black", color: "white" }}
      >
        <Grid2 size={{ xs: 12, sm: 6, md: 3 }} className="pt-4">
          <Typography className="pb-5" variant="h6">
            Company
          </Typography>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              About
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Jobs
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Blogs
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Press
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Partners
            </Button>
          </Box>
        </Grid2>
        <Grid2 size={{ xs: 12, sm: 6, md: 3 }} className="pt-4">
          <Typography className="pb-5" variant="h6">
            Solutions
          </Typography>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Marketing
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Analysis
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Commerce
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Insights
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Support
            </Button>
          </Box>
        </Grid2>
        <Grid2 size={{ xs: 12, sm: 6, md: 3 }} className="pt-4">
          <Typography className="pb-5" variant="h6">
            Documentation
          </Typography>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Guides
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              API Stats
            </Button>
          </Box>
        </Grid2>
        <Grid2 size={{ xs: 12, sm: 6, md: 3 }} className="pt-4">
          <Typography className="pb-5" variant="h6">
            Legal
          </Typography>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Claim
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Privacy
            </Button>
          </Box>
          <Box>
            <Button
              className="white"
              sx={{ textTransform: "none", color: "white" }}
            >
              {" "}
              Terms
            </Button>
          </Box>
        </Grid2>
        <Grid2 size={{ xs: 12 }} className="pt-20">
          <Typography component="p" variant="body2" align="center">
            &copy; My Company. All rights reserved
          </Typography>
          <Typography component="p" variant="body2" align="center">
            Made with love by me.
          </Typography>
        </Grid2>
      </Grid2>
    </div>
  );
};

export default Footer;
