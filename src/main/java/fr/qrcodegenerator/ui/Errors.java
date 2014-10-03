package fr.qrcodegenerator.ui;

/**
 * User: Pascal AUREGAN
 * Date: 9/29/14
 * first number means the group
 * second number means business or technical 1:business, 0 technical
 * third number means the error
 */
public enum Errors {
    /*File chooser errors*/
    ERR_101("File chooser should not be null"),
    ERR_102("Selected file should not be null"),
    ERR_110("File %s does not exist"),

    /*Int textfield*/
    ERR_201("Int field should be not null"),//JTextField
    ERR_202("Int field should be not null"),//JTextField.getText
    ERR_210("Int field length should be empty"),
    ERR_211("is not a valid number"),

    /*String textField*/
    ERR_300("File pattern field should not be null"),//JTextField
    ERR_301("File pattern should not be null"),//JTextField.getText
    ERR_310("File pattern is empty"),

    /*FileChooser Errors*/
    ERR_400("URL Field should not be null"),
    ERR_410("URL field should be valid (http://www.google.com)");



    private final String message;

    Errors(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.name() + ": " + message;
    }
}
