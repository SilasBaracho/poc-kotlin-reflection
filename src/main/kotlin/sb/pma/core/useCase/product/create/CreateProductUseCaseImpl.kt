package sb.pma.core.useCase.product.create

import sb.pma.core.domain.product.gateway.FindProductByNameAndActiveGateway
import sb.pma.core.domain.product.gateway.SaveProductGateway
import sb.pma.core.domain.product.model.ProductImpl
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.CreateProductUseCase
import sb.pma.core.domain.productCategory.gateway.FindOrCreateProductCategoryGateway
import sb.pma.infrastructure.exception.IllegalBusinessException
import sb.pma.infrastructure.utils.LowerCaseConverter
import java.math.BigDecimal

class CreateProductUseCaseImpl(
    private val findOrCreateProductCategoryGateway: FindOrCreateProductCategoryGateway,
    private val findProductByNameAndActiveGateway: FindProductByNameAndActiveGateway,
    private val saveProductGateway: SaveProductGateway,
): CreateProductUseCase {

    override operator fun invoke(input: CreateProductInput): ProductOutput {
        val payload = LowerCaseConverter.execute(input)

        findProductByNameAndActiveGateway.execute(payload.name).ifPresent {
            throw IllegalBusinessException("There is already a product with the registered name and it is active.")
        }

        if(payload.price == BigDecimal.ZERO)
            throw IllegalBusinessException("The product cannot be registered with the price equal to zero")

        val productCategory = findOrCreateProductCategoryGateway.execute(payload.productCategory)

        val product = saveProductGateway.execute(
            ProductImpl(
                idPartner = payload.idPartner,
                name = payload.name,
                price = payload.price,
                description = payload.description,
                extraIngredientLimit = payload.extraIngredientLimit,
                productCategory = productCategory
            )
        )

        return ProductOutputImpl(product)
    }

}