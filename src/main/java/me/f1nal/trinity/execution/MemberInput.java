package me.f1nal.trinity.execution;

import me.f1nal.trinity.remap.DisplayName;

public abstract class MemberInput<N> extends Input<N> {
    private final ClassInput owner;
    private final MemberDetails details;
    private final DisplayName displayName;

    protected MemberInput(N node, ClassInput owner, MemberDetails details) {
        super(node);
        this.owner = owner;
        this.details = details;
        this.displayName = new DisplayName(details.getName());
    }

    @Override
    public final ClassInput getOwningClass() {
        return owner;
    }

    public final MemberDetails getDetails() {
        return details;
    }

    @Override
    public final DisplayName getDisplayName() {
        return displayName;
    }

    public final String getDescriptor() {
        return details.getDesc();
    }
}
