package com.ecom.productservice.services;

import com.ecom.productservice.exception.NotFoundException;
import com.ecom.productservice.models.Category;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import org.springframework.stereotype.Service;
import com.ecom.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakestoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient)
    {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public Product getProductById(Long id) throws NotFoundException {
        return convertToProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtoList = fakeStoreProductServiceClient.getAllProducts();

        List<Product> fakeProductsList = new ArrayList<Product>();
        if(fakeStoreProductDtoList!=null)
        {
            for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList)
            {
                fakeProductsList.add(convertToProduct(fakeStoreProductDto));
            }
        }

        return fakeProductsList;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws NotFoundException {
        if(id<1 || id>20)
        {
            throw new NotFoundException("Product with id: "+id+" does not exist");
        }
        FakeStoreProductDto fakeStoreProductDto = convertToFakeStoreProductDto(product);
        FakeStoreProductDto fakeStoreProductDtoResponse = fakeStoreProductServiceClient.updateProduct(id,
                fakeStoreProductDto);

        return convertToProduct(fakeStoreProductDtoResponse);
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct(Product fakeProduct) {
        FakeStoreProductDto fakeStoreProductDto = convertToFakeStoreProductDto(fakeProduct);
        FakeStoreProductDto fakeStoreProductDtoResponse =
                fakeStoreProductServiceClient.createProdcut(fakeStoreProductDto);
        return convertToProduct(fakeStoreProductDtoResponse);
    }

    @Override
    public Product deleteProduct() {
        return null;
    }

    private Product convertToProduct(FakeStoreProductDto dto) {
        if(dto==null)
        {
            return null;
        }
        Product fakeProduct = new Product();
        fakeProduct.setId(dto.getId());
        fakeProduct.setTitle(dto.getTitle());
        fakeProduct.setPrice(dto.getPrice());
        fakeProduct.setDescription(dto.getDescription());

        Category category = new Category();
        category.setId(0L);
        category.setTitle(dto.getCategory());
        fakeProduct.setCategory(category);

        return fakeProduct;
    }

    private FakeStoreProductDto convertToFakeStoreProductDto(Product product) {
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        if (product.getCategory() != null) {
            dto.setCategory(product.getCategory().getTitle());
        }
        // Assuming you have a way to set the image for the dto, you can add that here
        // dto.setImage(product.getImage());
        return dto;
    }
}
