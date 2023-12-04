import { Container, Row, Col } from "reactstrap";
import Helmet from "../components/Helmet/Helmet";
import CommonSection from "../components/UI/CommonSection";
import { useAppContext } from "../AppContext";


const CarListing = () => {
  const { searchResultsMakeModel, searchResultsType, searchResultsMileage } = useAppContext();
  // Check if searchResults is an array and has length > 0
  return (
    <Helmet title="Cars">
      <CommonSection title="Car Listing" />

      <section>
        <Container>
          <Row>
            <Col lg="12">

              {/* Display search results for Make and Model */}
              <div className="search__results">
                {searchResultsMakeModel.map((result, index) => (
                    <div key={index}>
                      <p>{result}</p>
                    </div>
                ))}
              </div>

              {/* Display search results for Vehicle Type */}
              <div className="search__results">
                {searchResultsType.map((result, index) => (
                    <div key={index}>
                      <p>{result}</p>
                    </div>
                ))}
              </div>

              {/* Display search results for Mileage */}
              <div className="search__results">
                {searchResultsMileage.map((result, index) => (
                    <div key={index}>
                      <p>{result}</p>
                    </div>
                ))}
              </div>
                    <button>Add Car</button>
                    <button>Delete Car</button>
            </Col>
          </Row>
        </Container>
      </section>
    </Helmet>
  );
};

export default CarListing;
