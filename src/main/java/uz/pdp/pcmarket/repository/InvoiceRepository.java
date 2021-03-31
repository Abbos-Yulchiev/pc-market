package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Invoice;
import uz.pdp.pcmarket.projection.CustomInvoice;

@RepositoryRestResource(path = "invoice", collectionResourceRel = "list", excerptProjection = CustomInvoice.class)
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
