Feature: Car Details And Valuation

Scenario Outline: Getting car details and valuation from car valuation website
  Given The car registration number is available
  When I open website and search on reg
  Then I expect to get <VARIANT_REG>, <MAKE>, <MODEL>, <YEAR> of the car
  Examples:
  | VARIANT_REG | MAKE       | MODEL                                                    | YEAR
  | SG18HTN     | Volkswagen | Golf 1.5 TSI EVO SE Nav SG18 HTN                         | 2018
  | AD58VNF     | BMW        | 1 SERIES DIESEL COUPE - 120d M Sport 2dr                 | 2008
  | BW57BOF     | TOYOTA     | YARIS HATCHBACK - 1.0 VVT-i T2 3dr                       | 2008
  | KT17DLX     | SKODA      | SUPERB DIESEL ESTATE - 2.0 TDI CR 190 Sport Line 5dr DSG | 2017