package com.example.application.views.report;

import com.example.application.model.Category;
import com.example.application.repository.CategoryRepository;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Pembuatan Pengaduan Layanan Masyarakat")
@Route(layout = MainLayout.class, value = "create-report")
public class CreateReportFormView extends VerticalLayout {
    private CategoryRepository categoryRepository;
    public CreateReportFormView(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        createForm();
    }
    private void createForm(){
        setAlignItems(Alignment.STRETCH);
        EmailField emailField = new EmailField();
        emailField.setLabel("Email Adress");
        emailField.setErrorMessage("Enter a valid email address");
        emailField.setPrefixComponent(VaadinIcon.ENVELOPE.create());

        ComboBox<Category> category = new ComboBox<>("Category");
        category.setItems(categoryRepository.findAll());
        category.setItemLabelGenerator(Category::getCategoryName);

        TextArea textArea = new TextArea("Laporan");

        Button submitButton = new Button("Submit");

        add(emailField,category, textArea, submitButton);
    }
}
