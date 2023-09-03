package sb.pma.infrastructure.utils

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties

object LowerCaseConverter {
    fun <T : Any> execute(obj: T): T {
        val clazz = obj::class
        val properties = clazz.memberProperties

        for (property in properties) {
            if (property.returnType.classifier == String::class) {
                if (property is KMutableProperty1<*, *>) {
                    val value = property.get(obj as Nothing) as String
                    value?.let {
                        property.set(obj as Nothing, toLowerCase(it) as Nothing)
                    }
                }
            }
        }

        return obj
    }

    private fun toLowerCase(input: String) = input.lowercase()
}