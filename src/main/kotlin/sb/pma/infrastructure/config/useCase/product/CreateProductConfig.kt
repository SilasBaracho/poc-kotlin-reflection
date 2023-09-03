package sb.pma.infrastructure.config.useCase.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.product.useCase.CreateProductUseCase
import sb.pma.core.useCase.product.create.CreateProductUseCaseImpl
import sb.pma.infrastructure.resources.product.gateway.FindProductByNameAndActiveGatewayImpl
import sb.pma.infrastructure.resources.product.gateway.SaveProductGatewayImpl
import sb.pma.infrastructure.resources.productCategory.gateway.FindOrCreateProductCategoryGatewayImpl

@Configuration
class CreateProductConfig {

    @Bean
    fun createProductUseCase(
        findOrCreateProductCategoryGateway: FindOrCreateProductCategoryGatewayImpl,
        findProductByNameAndActiveGateway: FindProductByNameAndActiveGatewayImpl,
        saveProductGateway: SaveProductGatewayImpl,
    ): CreateProductUseCase{
        return CreateProductUseCaseImpl(
            findOrCreateProductCategoryGateway,
            findProductByNameAndActiveGateway,
            saveProductGateway,
        )
    }
}