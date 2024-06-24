package designpattern.팩토리.framework;

public abstract class Factory {

    // 만들고. 등록하여. 리턴한다.
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    // 만들다.
    protected abstract Product createProduct(String owner);

    // 등록하다.
    protected abstract void registerProduct(Product product);

}
