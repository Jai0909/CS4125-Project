import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import Home from "../pages/Home";
import CarListing from "../pages/CarListing";
import NotFound from "../pages/NotFound";
import Register from "../pages/Register";
import Login from "../pages/Login";

const Routers = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/home" />} />
      <Route path="/home" element={<Home />} />
      <Route path="/cars" element={<CarListing />} />
      <Route path="*" element={<NotFound />} />
        <Route path="/register" element= { <Register/>} />
        <Route path="/login" element= { <Login/>} />
    </Routes>
  );
};

export default Routers;