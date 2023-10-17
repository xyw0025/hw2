package controller;

import java.util.Arrays;

/**
 * Class to validate the inputs entered by the user in the Input fields
 */
public class InputValidation {

  /**
   * Function to validate the amount value
   * @param amount value entered in the amount field by the user
   * @return boolean indicating whether the value adheres by the rules or not
   */
  public static boolean isValidAmount(double amount) {
    
    // Check range
    if(amount >1000) {
      return false;
    }
    if (amount < 0){
      return false;
    }
    if (amount == 0){
      return false;
    }
    return true;
  }

  /**
   * Function to valdidate the category value
   * @param category category entered by the user in the category input field
   * @return boolean value indicating whether it falls into the list of allowed  categories
   */
  public static boolean isValidCategory(String category) {

    if(category == null) {
      return false; 
    }
  
    if(category.trim().isEmpty()) {
      return false;
    }

    if(!category.matches("[a-zA-Z]+")) {
      return false;
    }

    String[] validWords = {"food", "travel", "bills", "entertainment", "other"};

    if(!Arrays.asList(validWords).contains(category.toLowerCase())) {
      // invalid word  
      return false;
    }
  
    return true;
  
  }

}