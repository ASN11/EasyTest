package astracode.easytest.views;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("") // map view to the root
class MainView extends AppLayout {
    public MainView() {
        H1 title = new H1("Easy Testing");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("left", "var(--lumo-space-l)").set("margin", "0")
                .set("position", "absolute");

        Tabs tabs = getTabs();

        addToNavbar(title, tabs);
    }

    private Tabs getTabs() {
        Tab tab1 = new Tab("Первый таб");
        Tab tab2 = new Tab("Второй таб");
        Tab tab3 = new Tab("Третий таб");
        Tabs tabs = new Tabs(tab1, tab2, tab3);
        tabs.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("position", "absolute")
                .set("left", "50%") // Move to the center
                .set("transform", "translateX(-50%)"); // Adjust for centering;
        return tabs;
    }
}
