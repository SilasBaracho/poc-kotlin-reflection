package sb.pma.infrastructure.resources.product.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sb.pma.infrastructure.utils.ConstantsUtils.ConstantConfig.PRODUCT_URI_RESOURCE_V1
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.useCase.CreateProductUseCase
import sb.pma.core.domain.product.useCase.DeleteProductUseCase
import sb.pma.core.domain.product.useCase.FindAllProductByIdPartnerUseCase
import sb.pma.core.domain.product.useCase.FindProductByIdUseCase
import sb.pma.core.useCase.product.create.CreateProductInput
import sb.pma.core.useCase.product.delete.DeleteProductInput
import sb.pma.core.useCase.product.findById.FindProductByIdInput
import java.util.UUID

@RestController
@RequestMapping(PRODUCT_URI_RESOURCE_V1)
class ProductController(
    val createProductUseCase: CreateProductUseCase,
    val deleteProductUseCase: DeleteProductUseCase,
    val findProductByIdUseCase: FindProductByIdUseCase,
    val findAllProductByIdPartnerUseCase: FindAllProductByIdPartnerUseCase
) {

    @PostMapping
    fun create(@RequestBody payload: CreateProductInput): ProductOutput {
        return createProductUseCase.invoke(payload)
    }

    @DeleteMapping("/{id_product}/partner/{id_partner}")
    fun delete(
        @PathVariable("id_product") idProduct: UUID,
        @PathVariable("id_partner") idPartner: UUID
    ){
        val payload = DeleteProductInput(idPartner, idProduct)
        deleteProductUseCase.invoke(payload)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") idProduct: String): ProductOutput {
        val payload = FindProductByIdInput(UUID.fromString(idProduct))
        return findProductByIdUseCase.invoke(payload)
    }

    @GetMapping("/find-all/{id_partner}")
    fun findAllProductByIdPartner(@PathVariable("id_partner") idPartner: UUID): List<ProductOutput> {
        return findAllProductByIdPartnerUseCase.invoke(idPartner)
    }
}