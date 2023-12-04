import React, { useRef } from "react";

import { Container, Row, Col } from "reactstrap";
import { Link, NavLink } from "react-router-dom";
import "../../styles/header.css";
import { useAppContext } from "../../AppContext";


const navLinks = [
  {
    path: "/home",
    display: "Home",
  },
  {
    path: "/cars",
    display: "Cars",
  },
];

const Header = () => {
  const menuRef = useRef(null);
  const toggleMenu = () => menuRef.current.classList.toggle("menu__active");
  const { setSearchResultsMakeModel, setSearchResultsType, setSearchResultsMileage } = useAppContext();


  const handleMakeModelSearch = async (query) => {
    try {
      const response = await fetch(`http://localhost:8085/user/searchMakeModel/${query}`);
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      const data = await response.json();
      console.log(data); // Log fetched data
      setSearchResultsMakeModel(data);
    } catch (error) {
      console.error("There was a problem with the fetch operation:", error);
    }
  };
  

  const handleVehicleTypeSearch = async (query) => {
    try {
      const response = await fetch(`http://localhost:8085/user/searchType/${query}`);
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      const data = await response.json();
      console.log(data); // Log fetched data
      setSearchResultsType(data);
    } catch (error) {
      console.error("There was a problem with the fetch operation:", error);
    }
  };

  const handleMileageSearch = async (query) => {
    try {
      const response = await fetch(`http://localhost:8085/user/searchMilage/${query}`);
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      const data = await response.json();
      console.log(data); // Log fetched data
      setSearchResultsMileage(data);
    } catch (error) {
      console.error("There was a problem with the fetch operation:", error);
    }
  };

  const onMakeModelInputChange = async (event) => {
    const query = event.target.value;
    handleMakeModelSearch(query);
    setSearchResultsType([]); // Reset other search results
    setSearchResultsMileage([]);
  };

  const onVehicleTypeInputChange = async (event1) => {
    const query = event1.target.value;
    handleVehicleTypeSearch(query);
    setSearchResultsMakeModel([]); // Reset other search results
    setSearchResultsMileage([]);
  };

  const onMileageInputChange = async (event2) => {
    const query = event2.target.value;
    handleMileageSearch(query);
    setSearchResultsMakeModel([]); // Reset other search results
    setSearchResultsType([]);
  };

  return (
    <header className="header">
      {/* ============ header top ============ */}
      <div className="header__top">
        <Container>
          <Row>
            <Col lg="6" md="6" sm="6">
              <div className="header__top__left">
                <span>Need Help?</span>
                <span className="header__top__help">
                  <i class="ri-phone-fill"></i> +353 891234567
                </span>
              </div>
            </Col>

            <Col lg="6" md="6" sm="6">
              <div className="header__top__right d-flex align-items-center justify-content-end gap-3">
                <Link to="/login" className=" d-flex align-items-center gap-1">
                  <i class="ri-login-circle-line"></i> Login
                </Link>

                <Link to="/register" className=" d-flex align-items-center gap-1">
                  <i class="ri-user-line"></i> Register
                </Link>
              </div>
            </Col>
          </Row>
        </Container>
      </div>

      {/* =============== header middle =========== */}
      <div className="header__middle">
        <Container>
          <Row>
            <Col lg="4" md="3" sm="4">
              <div className="logo">
                <h1>
                  <Link to="/home" className=" d-flex align-items-center gap-2">
                    <i class="ri-car-line"></i>
                    <span>
                      KISS Car Rental <br /> Service
                    </span>
                  </Link>
                </h1>
              </div>
            </Col>

            <Col lg="3" md="3" sm="4">
              <div className="header__location d-flex align-items-center gap-2">
                <span>
                  <i class="ri-earth-line"></i>
                </span>
                <div className="header__location-content">
                  <h4>Limerick City</h4>
                  <h6>Co. Limerick, Ireland</h6>
                </div>
              </div>
            </Col>

            <Col lg="3" md="3" sm="4">
              <div className="header__location d-flex align-items-center gap-2">
                <span>
                  <i class="ri-time-line"></i>
                </span>
                <div className="header__location-content">
                  <h4>Open 7 days</h4>
                  <h6>9am - 9pm</h6>
                </div>
              </div>
            </Col>

            <Col
              lg="2"
              md="3"
              sm="0"
              className=" d-flex align-items-center justify-content-end "
            >
            </Col>
          </Row>
        </Container>
      </div>

      {/* ========== main navigation =========== */}

      <div className="main__navbar">
        <Container>
          <div className="navigation__wrapper d-flex align-items-center justify-content-between">
            <span className="mobile__menu">
              <i class="ri-menu-line" onClick={toggleMenu}></i>
            </span>

            <div className="navigation" ref={menuRef} onClick={toggleMenu}>
              <div className="menu">
                {navLinks.map((item, index) => (
                  <NavLink
                    to={item.path}
                    className={(navClass) =>
                      navClass.isActive ? "nav__active nav__item" : "nav__item"
                    }
                    key={index}
                  >
                    {item.display}
                  </NavLink>
                ))}
              </div>
            </div>

            <div className="nav__right">
              <div className="search__box">
              <input type="text" placeholder="Search by Make and Model" onChange={onMakeModelInputChange} />
                <span>
                  <i class="ri-search-line"></i>
                </span>
              </div>
              <div className="search__box">
                <input type="text" placeholder="Search by Vehicle Type" onChange={onVehicleTypeInputChange} />
                <span>
                  <i class="ri-search-line"></i>
                </span>
              </div>
              <div className="search__box">
                <input type="text" placeholder="Search by Mileage" onChange={onMileageInputChange} />
                <span>
                  <i class="ri-search-line"></i>
                </span>
              </div>
            </div>
          </div>
        </Container>
      </div>
    </header>
  );
};

export default Header;
