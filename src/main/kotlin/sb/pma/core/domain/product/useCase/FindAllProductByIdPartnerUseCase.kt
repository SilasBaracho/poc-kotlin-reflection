package sb.pma.core.domain.product.useCase

import sb.pma.core.domain.product.output.ProductOutput
import java.util.*

interface FindAllProductByIdPartnerUseCase {

    operator fun invoke(idPartner: UUID): List<ProductOutput>
}