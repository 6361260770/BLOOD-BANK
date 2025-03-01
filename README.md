# BLOOD-BANK
# Blood Donation Management System

## Overview

This project is a Blood Donation Management System designed to store and manage donor details and available blood groups.

## Database Schema

### **Blood Group Table (****`blggroup`****):**

| Column    | Data Type | Nullable |
| --------- | --------- | -------- |
| B\_minus  | int       | YES      |
| AB\_plus  | int       | YES      |
| AB\_minus | int       | YES      |
| O\_plus   | int       | YES      |
| O\_minus  | int       | YES      |

### **Donor Table (****`donar`****):**

| Column     | Data Type   | Nullable |
| ---------- | ----------- | -------- |
| name       | varchar(50) | NO       |
| ph         | longtext    | NO       |
| place      | varchar(45) | NO       |
| bloodGroup | varchar(45) | NO       |
| date       | date        | NO       |

## Setup Instructions

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/your-repository.git
   ```
2. Navigate to the project directory:
   ```sh
   cd your-repository
   ```
3. Set up the database using the schema provided.
4. Run the application following the framework-specific instructions.

## Usage

- Add, update, and delete donor details.
- Track available blood groups.
- Search donors based on blood group and location.

## Contributing

Feel free to fork the repository and submit pull requests for improvements.

## License



This project is open-source under the MIT License.
