import java.util.Vector;

import org.apache.commons.text.StringEscapeUtils;

public class Customer extends NamedObject {
    private Vector<Rental> rentals = new Vector<Rental>();

    public static Customer get(String name) {
        return (Customer) Registry.get("Customers", name);
    }

    public Customer(String name) {
        super(name);
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void prepareStatement(StringBuilder sb) {
        double balance = 0.0;
        int rewardPoints = 0;
        sb = new StringBuilder();
        sb.append("Rental statement for ").append(getName()).append("\n");
        for (Rental rental : rentals) {
            double amount = 0.0;
            switch (rental.getDisk().getDiskType()) {
            case BLUERAY:
                amount = getBlueRayrentalPrice(rental);
                rewardPoints = getBlueRayRewards(rental);
                break;
            case DVD:
                amount = getDVDrentalPrice(rental);
                rewardPoints += 1;
                rewardPoints = getDVDRewards(rental);
                break;
            }
            balance += amount;
            sb.append("\t").append(rental.getDisk().getMovie().getName()).append("\t").append(String.valueOf(amount))
                    .append("\n");
        }
        sb.append("Balance is ").append(String.valueOf(balance)).append("\n");
        sb.append("You earned ").append(rewardPoints).append(" reward points");
    }

    public String getStatement() {
        StringBuilder sb = null;
        prepareStatement(sb);
        return sb.toString();

    }

    public String getHTMLStatement() {
//      Download Apache Commons Text Library. Link - https://mvnrepository.com/artifact/org.apache.commons/commons-text
        StringBuilder sb = null;
        prepareStatement(sb);
        String statementHTML = StringEscapeUtils.escapeHtml4(sb.toString());
        return statementHTML;

    }

    private double getDVDrentalPrice(Rental rental) {
        double amount = 0.0;
        switch (rental.getDisk().getMovie().getPriceCategory()) {

        case Movie.CHILDRENS:
            amount += 2;
            if (rental.getDays() > 2) {
                amount += (rental.getDays() - 2) * 1.5;
            }
            break;
        case Movie.NEW_RELEASE:
            amount += rental.getDays() * 3;
            break;
        case Movie.REGULAR:
            amount += 1.5;
            if (rental.getDays() > 3) {
                amount += (rental.getDays() - 3) * 1.5;
            }
            break;
        }
        return amount;
    }

    private double getBlueRayrentalPrice(Rental rental) {
        double amount = 0.0;
        switch (rental.getDisk().getMovie().getPriceCategory()) {

        case Movie.CHILDRENS:
            amount += 3;
            if (rental.getDays() > 3) {
                amount += (rental.getDays() - 2) * 2.5;
            }
            break;
        case Movie.NEW_RELEASE:
            amount += rental.getDays() / 3;
            break;
        case Movie.REGULAR:
            amount *= 1.5;
            if (rental.getDays() > 3) {
                amount *= (rental.getDays() - 3) * 1.5;
            }
            break;
        }
        return amount;
    }

    private int getBlueRayRewards(Rental rental) {
        int rewardPoints = 0;
        if ((rental.getDisk().getMovie().getPriceCategory() == Movie.REGULAR) && rental.getDays() > 5) {
            rewardPoints += 2;
        } else {
            rewardPoints += 1;
        }
        return rewardPoints;
    }

    private int getDVDRewards(Rental rental) {
        int rewardPoints = 0;
        if ((rental.getDisk().getMovie().getPriceCategory() == Movie.NEW_RELEASE) && rental.getDays() > 1) {
            rewardPoints += 1;
        }
        return rewardPoints;
    }

    public void register() {
        Registry.add("Customers", this);
    }
}
