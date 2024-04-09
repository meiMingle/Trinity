package me.f1nal.trinity.execution.var;

import me.f1nal.trinity.database.IDatabaseSavable;
import me.f1nal.trinity.database.object.DatabaseVariable;
import imgui.type.ImString;
import me.f1nal.trinity.gui.windows.impl.cp.IRenameHandler;
import me.f1nal.trinity.gui.windows.impl.cp.RenameHandler;

public class Variable implements IDatabaseSavable<DatabaseVariable>, IRenameHandler {
    private final VariableTable table;
    private ImString nameProperty;
    private String name;

    public Variable(VariableTable table, String name) {
        this.table = table;
        this.name = name;
    }

    public VariableTable getTable() {
        return table;
    }

    public String getName() {
        return nameProperty != null ? nameProperty.get() : name;
    }

    public ImString getNameProperty() {
        if (this.nameProperty == null) {
            this.nameProperty = new ImString(name, 0x100);
        }
        return this.nameProperty;
    }

    public boolean isEditable() {
        return true;
    }

    public int findIndex() {
        return table.getIndex(this);
    }

    @Override
    public DatabaseVariable createDatabaseObject() {
        return new DatabaseVariable(table.getMethod().getDetails(), findIndex(), this.getName());
    }

    @Override
    public RenameHandler getRenameHandler() {
        return new RenameHandler() {
            @Override
            public String getFullName() {
                return getName();
            }

            @Override
            public void rename(String newName) {
                getNameProperty().set(newName);
                save();
            }
        };
    }
}
