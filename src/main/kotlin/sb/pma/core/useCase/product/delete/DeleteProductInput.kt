package sb.pma.core.useCase.product.delete

import java.util.UUID

data class DeleteProductInput(
    val idPartner: UUID,
    val idProduct: UUID,
): java.io.Serializable{}
