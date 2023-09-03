package sb.pma.core.useCase.product.create

import sb.pma.core.useCase.productCategory.findByName.FindProductCategoryByNameInput
import java.math.BigDecimal
import java.util.UUID

data class CreateProductInput(
    val idPartner: UUID,
    var name: String,
    var description: String? = null,
    val price: BigDecimal,
    val extraIngredientLimit: Int?,
    val productCategory: FindProductCategoryByNameInput
): java.io.Serializable {}