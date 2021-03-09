package EXERCISEInterfacesAndAbstraction.military;

import EXERCISEInterfacesAndAbstraction.military.interfaces.SpecialisedSoldier;

public  class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corp;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName,
                                  double salary, Corp corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
    }

    @Override
    public Corp getCorp() {
        return this.corp;
    }
}
