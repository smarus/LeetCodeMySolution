package aquarium.buildings

open class BaseBuildingMaterial(var numberNeeded: Int = 1) {}


class Wood() : BaseBuildingMaterial(numberNeeded = 4) {}

class Brick() : BaseBuildingMaterial(numberNeeded = 8) {}

class Building<T : BaseBuildingMaterial>(var buildingMaterial: T, baseMaterialsNeeded: Int = 100) {

    var actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        print("${actualMaterialsNeeded} ${buildingMaterial::class.simpleName} required")


    }

}

fun main(args: Array<String>) {
    val building = Building(Wood())
    building.build()
}
