package astracode.easytest.views;

import astracode.easytest.model.TestCase;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;


@Route("/add")
public class TextAreaFormView extends VerticalLayout {

    private final TextArea codeArea = new TextArea("Введите код");
    private final TextArea testArea = new TextArea("Введите код тестов");
    private final Button saveButton = new Button("Запустить тест");
    private final String MIN_HEIGHT = "600px";

    public TextAreaFormView() {
        configureComponents();
        buildLayout();
    }

        private void configureComponents() {
            codeArea.setWidthFull();
            codeArea.setMinHeight(MIN_HEIGHT);
            testArea.setWidthFull();
            testArea.setMinHeight(MIN_HEIGHT);

            // Нажатие кнопки для сохранения текста
            saveButton.addClickListener(event -> {
                String enteredCodeText = codeArea.getValue();
                String enteredTestText = testArea.getValue();
                Notification.show("Код отправлен на тестирование");

                TestCase testCase = new TestCase(enteredCodeText, enteredTestText);

            });
        }

    private void configureDialog() {
        HorizontalLayout textAreaLayout = new HorizontalLayout(codeArea, testArea);
        textAreaLayout.setWidthFull(); // Занимает всю доступную ширину

        // Создание макета формы
        VerticalLayout mainLayout = new VerticalLayout(textAreaLayout, saveButton);
        mainLayout.setWidth("1600px"); // Задаем ширину главного контейнера

//         Создание и отображение диалогового окна с формой
        Dialog dialogCode = new Dialog();
        dialogCode.add(mainLayout);
        dialogCode.open();
    }


    private void buildLayout() {
        Button openDialog = new Button("Ввести данные");
        openDialog.addClickListener(event -> configureDialog());

        VerticalLayout layout = new VerticalLayout(getAppLayout(), openDialog);
        add(layout);
    }


    private Component getAppLayout() {
        AppLayout appLayout = new AppLayout();

        H1 title = new H1("Easy Testing");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("left", "var(--lumo-space-l)")
                .set("margin", "0")
                .set("position", "absolute");

        appLayout.addToNavbar(title);

        return appLayout;
    }
}

