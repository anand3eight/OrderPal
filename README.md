# OrderPal Food Ordering System

OrderPal is a food ordering system built using Java and Javax Swing, with data storage managed through MSAccess.

## Technologies Used

* Java
* Javax Swing
* MSAccess

## Getting Started

To use OrderPal in IntelliJ, follow these steps:

1. **Load the JDBC Driver:**
   Load the JDBC Driver in your project. You can refer to this [video tutorial](https://www.youtube.com/watch?v=xM1KNbRkF3A) for guidance.

2. **Configure Database Path and Folders:**
   Update the database path and relevant folder locations in the following code files:
   * `UserBill\OrderBill.java` - Update `Line 77`
   * `UserBill\RetrieveDetails.java` - Update `Line 9`
   * `UserLogin\InsertUser.java` - Update `Line 13`
   * `UserLogin\VerifySignIn.java` - Update `Line 13`
   * `UserOrder\RetrieveHotels.java` - Update `Line 7`
   * `UserOrder\RetrieveItems.java` - Update `Line 8`
   * `UserOrder\StoreOrder.java` - Update `Line 9`

   Use the format: `C:\OrderPal\OrderPalDB.accdb`

3. **Run the Application:**
   Run the `MainClass.java` file to launch the main application.

## Contributing

This project welcomes contributions from the community. Feel free to fork the repository, make changes, and submit pull requests.

Feel free to customize and improve the README further based on your project's specific needs.
