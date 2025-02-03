package academy.digitallab.shopping_service.service;


import academy.digitallab.shopping_service.Entity.Invoice;
import academy.digitallab.shopping_service.Repository.InvoiceItemsRepository;
import academy.digitallab.shopping_service.Repository.InvoicesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoicesRepository invoicesRepository;

    @Autowired
    InvoiceItemsRepository invoiceItemsRepository;


    @Override
    public List<Invoice> findInvoiceAll() {
        return invoicesRepository.findAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB = invoicesRepository.findByNumberInvoice ( invoice.getNumberInvoice () );
        if (invoiceDB !=null){
            return  invoiceDB;
        }
        invoice.setState("CREATED");
        return invoicesRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if (invoiceDB == null){
            return  null;
        }
        invoiceDB.setCustomerId(invoice.getCustomerId());
        invoiceDB.setDescription(invoice.getDescription());
        invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
        invoiceDB.getItems().clear();
        invoiceDB.setItems(invoice.getItems());
        return invoicesRepository.save(invoiceDB);
    }

    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if (invoiceDB == null){
            return  null;
        }
        invoiceDB.setState("DELETED");
        return invoicesRepository.save(invoiceDB);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoicesRepository.findById(id).orElse(null);
    }
}
