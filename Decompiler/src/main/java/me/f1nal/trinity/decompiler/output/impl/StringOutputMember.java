package me.f1nal.trinity.decompiler.output.impl;

import me.f1nal.trinity.decompiler.output.OutputMember;
import me.f1nal.trinity.decompiler.output.OutputMemberVisitor;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StringOutputMember extends OutputMember {
    private String data;

    public StringOutputMember(int length) {
        super(length);
    }

    public StringOutputMember(int length, String data) {
        super(length);
        this.data = data;
    }

    @Override
    protected void serializeImpl(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.data);
    }

    @Override
    protected void deserializeImpl(DataInput dataInput) throws IOException {
        this.data = dataInput.readUTF();
    }

    public String getData() {
        return data;
    }

    @Override
    public void visit(OutputMemberVisitor visitor) {
        visitor.visitString(this);
    }
}
