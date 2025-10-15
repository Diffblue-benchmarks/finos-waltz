package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand.Builder;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PhysicalFlowCreateCommandDiffblueTest {
  /**
   * Test {@link PhysicalFlowCreateCommand#dataTypeIds()}.
   *
   * <p>Method under test: {@link PhysicalFlowCreateCommand#dataTypeIds()}
   */
  @Test
  @DisplayName("Test dataTypeIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PhysicalFlowCreateCommand.dataTypeIds()"})
  void testDataTypeIds() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertTrue(
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build()
            .dataTypeIds()
            .isEmpty());
  }
}
