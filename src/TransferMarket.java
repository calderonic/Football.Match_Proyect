public class TransferMarket {
    private int budget;

    public TransferMarket(int budget) {
        this.budget = budget;
    }

    public void buyPlayer(Player player) {
        if (budget >= player.getPrice()) {
            budget -= player.getPrice();
            System.out.println("Player bought: " + player.getName());
        } else {
            System.out.println("Not enough budget");
        }
    }
}
