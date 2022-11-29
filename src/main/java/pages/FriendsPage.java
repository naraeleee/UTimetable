package pages;

import java.util.Map;

public class FriendsPage extends Page{
    public FriendsPage(Router router, PageState pageState) {
        super(router, pageState, "Friends Page");
    }

    private enum Option {
        MANAGE_FRIENDS,
        MANAGE_BLOCKED,
        VIEW_FRIENDS
    }
    @Override
    public Page run() {

        Map<String, Option> options = Map.of(
                "Manage Friends", Option.MANAGE_FRIENDS,
                "Manage Blocked Friends", Option.MANAGE_BLOCKED,
                "View Friends", Option.VIEW_FRIENDS
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case MANAGE_BLOCKED:
                redirect = this.router.getManageBlockedPage();
                System.out.println("Redirecting to Manage Blocked Friends...");
                break;
            case MANAGE_FRIENDS:
                redirect = this.router.getManageFriendsPage();
                System.out.println("Redirecting to Manage Friends...");
                break;
            case VIEW_FRIENDS:
                redirect = this.router.getFriendsListPage();
                System.out.println("Redirecting to Friends List...");
                break;
        }
        return redirect;
    }
}