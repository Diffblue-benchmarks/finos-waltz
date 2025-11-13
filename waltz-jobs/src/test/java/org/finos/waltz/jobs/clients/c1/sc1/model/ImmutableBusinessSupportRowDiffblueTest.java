package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableBusinessSupportRow.Builder;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBusinessSupportRowDiffblueTest {
  /**
   * Test Builder {@link Builder#applicationId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationId(String)}
   */
  @Test
  @DisplayName("Test Builder applicationId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationId(String)"})
  void testBuilderApplicationId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act
    Builder actualApplicationIdResult = builderResult.applicationId("42");

    // Assert
    assertSame(builderResult, actualApplicationIdResult);
  }

  /**
   * Test Builder {@link Builder#applicationName(String)}.
   *
   * <ul>
   *   <li>When {@code Application Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationName(String)}
   */
  @Test
  @DisplayName("Test Builder applicationName(String); when 'Application Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationName(String)"})
  void testBuilderApplicationName_whenApplicationName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act
    Builder actualApplicationNameResult = builderResult.applicationName("Application Name");

    // Assert
    assertSame(builderResult, actualApplicationNameResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#endDate(String)}
   *   <li>{@link Builder#orgObjectId(String)}
   *   <li>{@link Builder#orgObjectName(String)}
   *   <li>{@link Builder#startDate(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow Builder.build()",
    "Builder Builder.endDate(String)",
    "Builder Builder.orgObjectId(String)",
    "Builder Builder.orgObjectName(String)",
    "Builder Builder.startDate(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualImmutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableBusinessSupportRow.endDate());
    assertEquals("2020-03-01", actualImmutableBusinessSupportRow.startDate());
    assertEquals("42", actualImmutableBusinessSupportRow.applicationId());
    assertEquals("42", actualImmutableBusinessSupportRow.domainObjectId());
    assertEquals("42", actualImmutableBusinessSupportRow.internalId());
    assertEquals("42", actualImmutableBusinessSupportRow.orgObjectId());
    assertEquals("Application Name", actualImmutableBusinessSupportRow.applicationName());
    assertEquals("Domain Object Name", actualImmutableBusinessSupportRow.domainObjectName());
    assertEquals("Org Object Name", actualImmutableBusinessSupportRow.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableBusinessSupportRow.status());
  }

  /**
   * Test Builder {@link Builder#domainObjectId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#domainObjectId(String)}
   */
  @Test
  @DisplayName("Test Builder domainObjectId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.domainObjectId(String)"})
  void testBuilderDomainObjectId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act
    Builder actualDomainObjectIdResult = builderResult.domainObjectId("42");

    // Assert
    assertSame(builderResult, actualDomainObjectIdResult);
  }

  /**
   * Test Builder {@link Builder#domainObjectName(String)}.
   *
   * <ul>
   *   <li>When {@code Domain Object Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#domainObjectName(String)}
   */
  @Test
  @DisplayName(
      "Test Builder domainObjectName(String); when 'Domain Object Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.domainObjectName(String)"})
  void testBuilderDomainObjectName_whenDomainObjectName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act
    Builder actualDomainObjectNameResult = builderResult.domainObjectName("Domain Object Name");

    // Assert
    assertSame(builderResult, actualDomainObjectNameResult);
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   *
   * <p>Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    ImmutableBusinessSupportRow instance =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBusinessSupportRow actualImmutableBusinessSupportRow = builderResult.build();
    assertEquals(instance, actualImmutableBusinessSupportRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   *
   * <p>Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    ImmutableBusinessSupportRow instance =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate(null)
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBusinessSupportRow actualImmutableBusinessSupportRow = builderResult.build();
    assertEquals(instance, actualImmutableBusinessSupportRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   *
   * <p>Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    ImmutableBusinessSupportRow instance =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId(null)
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBusinessSupportRow actualImmutableBusinessSupportRow = builderResult.build();
    assertEquals(instance, actualImmutableBusinessSupportRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   *
   * <p>Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    ImmutableBusinessSupportRow instance =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName(null)
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBusinessSupportRow actualImmutableBusinessSupportRow = builderResult.build();
    assertEquals(instance, actualImmutableBusinessSupportRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   *
   * <p>Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    ImmutableBusinessSupportRow instance =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate(null)
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBusinessSupportRow actualImmutableBusinessSupportRow = builderResult.build();
    assertEquals(instance, actualImmutableBusinessSupportRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#internalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#internalId(String)}
   */
  @Test
  @DisplayName("Test Builder internalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.internalId(String)"})
  void testBuilderInternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act
    Builder actualInternalIdResult = builderResult.internalId("42");

    // Assert
    assertSame(builderResult, actualInternalIdResult);
  }

  /**
   * Test Builder {@link Builder#status(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#status(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(EntityLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act
    Builder actualStatusResult = builderResult.status(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#copyOf(BusinessSupportRow)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#copyOf(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test copyOf(BusinessSupportRow); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.copyOf(BusinessSupportRow)"
  })
  void testCopyOf_thenReturnEndDateIs20200301() {
    // Arrange
    ImmutableBusinessSupportRow instance =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualCopyOfResult = ImmutableBusinessSupportRow.copyOf(instance);

    // Assert
    assertEquals("2020-03-01", actualCopyOfResult.endDate());
    assertEquals("2020-03-01", actualCopyOfResult.startDate());
    assertEquals("42", actualCopyOfResult.applicationId());
    assertEquals("42", actualCopyOfResult.domainObjectId());
    assertEquals("42", actualCopyOfResult.internalId());
    assertEquals("42", actualCopyOfResult.orgObjectId());
    assertEquals("Application Name", actualCopyOfResult.applicationName());
    assertEquals("Domain Object Name", actualCopyOfResult.domainObjectName());
    assertEquals("Org Object Name", actualCopyOfResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}, and {@link
   * ImmutableBusinessSupportRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBusinessSupportRow#equals(Object)}
   *   <li>{@link ImmutableBusinessSupportRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();
    ImmutableBusinessSupportRow immutableBusinessSupportRow2 =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertEquals(immutableBusinessSupportRow, immutableBusinessSupportRow2);
    assertEquals(immutableBusinessSupportRow.hashCode(), immutableBusinessSupportRow2.hashCode());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}, and {@link
   * ImmutableBusinessSupportRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBusinessSupportRow#equals(Object)}
   *   <li>{@link ImmutableBusinessSupportRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertEquals(immutableBusinessSupportRow, immutableBusinessSupportRow);
    int expectedHashCodeResult = immutableBusinessSupportRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableBusinessSupportRow.hashCode());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("Domain Object Name")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("42")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("Domain Object Name")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("42")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020/03/01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("Domain Object Name")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("Domain Object Name")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("42")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020/03/01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.PENDING)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBusinessSupportRow,
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBusinessSupportRow.equals(Object)",
    "int ImmutableBusinessSupportRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build(),
        "Different type to ImmutableBusinessSupportRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBusinessSupportRow#toString()}
   *   <li>{@link ImmutableBusinessSupportRow#applicationId()}
   *   <li>{@link ImmutableBusinessSupportRow#applicationName()}
   *   <li>{@link ImmutableBusinessSupportRow#domainObjectId()}
   *   <li>{@link ImmutableBusinessSupportRow#domainObjectName()}
   *   <li>{@link ImmutableBusinessSupportRow#endDate()}
   *   <li>{@link ImmutableBusinessSupportRow#internalId()}
   *   <li>{@link ImmutableBusinessSupportRow#orgObjectId()}
   *   <li>{@link ImmutableBusinessSupportRow#orgObjectName()}
   *   <li>{@link ImmutableBusinessSupportRow#startDate()}
   *   <li>{@link ImmutableBusinessSupportRow#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBusinessSupportRow.applicationId()",
    "String ImmutableBusinessSupportRow.applicationName()",
    "String ImmutableBusinessSupportRow.domainObjectId()",
    "String ImmutableBusinessSupportRow.domainObjectName()",
    "String ImmutableBusinessSupportRow.endDate()",
    "String ImmutableBusinessSupportRow.internalId()",
    "String ImmutableBusinessSupportRow.orgObjectId()",
    "String ImmutableBusinessSupportRow.orgObjectName()",
    "String ImmutableBusinessSupportRow.startDate()",
    "EntityLifecycleStatus ImmutableBusinessSupportRow.status()",
    "String ImmutableBusinessSupportRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    String actualToStringResult = immutableBusinessSupportRow.toString();
    String actualApplicationIdResult = immutableBusinessSupportRow.applicationId();
    String actualApplicationNameResult = immutableBusinessSupportRow.applicationName();
    String actualDomainObjectIdResult = immutableBusinessSupportRow.domainObjectId();
    String actualDomainObjectNameResult = immutableBusinessSupportRow.domainObjectName();
    String actualEndDateResult = immutableBusinessSupportRow.endDate();
    String actualInternalIdResult = immutableBusinessSupportRow.internalId();
    String actualOrgObjectIdResult = immutableBusinessSupportRow.orgObjectId();
    String actualOrgObjectNameResult = immutableBusinessSupportRow.orgObjectName();
    String actualStartDateResult = immutableBusinessSupportRow.startDate();

    // Assert
    assertEquals("2020-03-01", actualEndDateResult);
    assertEquals("2020-03-01", actualStartDateResult);
    assertEquals("42", actualApplicationIdResult);
    assertEquals("42", actualDomainObjectIdResult);
    assertEquals("42", actualInternalIdResult);
    assertEquals("42", actualOrgObjectIdResult);
    assertEquals("Application Name", actualApplicationNameResult);
    assertEquals(
        "BusinessSupportRow{internalId=42, status=ACTIVE, domainObjectId=42, domainObjectName=Domain Object"
            + " Name, applicationId=42, applicationName=Application Name, orgObjectId=42, orgObjectName=Org Object"
            + " Name, startDate=2020-03-01, endDate=2020-03-01}",
        actualToStringResult);
    assertEquals("Domain Object Name", actualDomainObjectNameResult);
    assertEquals("Org Object Name", actualOrgObjectNameResult);
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableBusinessSupportRow.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withApplicationId(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withApplicationId(String)}
   */
  @Test
  @DisplayName("Test withApplicationId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withApplicationId(String)"
  })
  void testWithApplicationId() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithApplicationIdResult =
        immutableBusinessSupportRow.withApplicationId("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithApplicationIdResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withApplicationId(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withApplicationId(String)}
   */
  @Test
  @DisplayName("Test withApplicationId(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withApplicationId(String)"
  })
  void testWithApplicationId_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithApplicationIdResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("applicationId")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withApplicationId("42");

    // Assert
    assertEquals("2020-03-01", actualWithApplicationIdResult.endDate());
    assertEquals("2020-03-01", actualWithApplicationIdResult.startDate());
    assertEquals("42", actualWithApplicationIdResult.applicationId());
    assertEquals("42", actualWithApplicationIdResult.domainObjectId());
    assertEquals("42", actualWithApplicationIdResult.internalId());
    assertEquals("42", actualWithApplicationIdResult.orgObjectId());
    assertEquals("Application Name", actualWithApplicationIdResult.applicationName());
    assertEquals("Domain Object Name", actualWithApplicationIdResult.domainObjectName());
    assertEquals("Org Object Name", actualWithApplicationIdResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithApplicationIdResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withApplicationName(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withApplicationName(String)}
   */
  @Test
  @DisplayName("Test withApplicationName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withApplicationName(String)"
  })
  void testWithApplicationName() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("42")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithApplicationNameResult =
        immutableBusinessSupportRow.withApplicationName("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithApplicationNameResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withApplicationName(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withApplicationName(String)}
   */
  @Test
  @DisplayName("Test withApplicationName(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withApplicationName(String)"
  })
  void testWithApplicationName_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithApplicationNameResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withApplicationName("42");

    // Assert
    assertEquals("2020-03-01", actualWithApplicationNameResult.endDate());
    assertEquals("2020-03-01", actualWithApplicationNameResult.startDate());
    assertEquals("42", actualWithApplicationNameResult.applicationId());
    assertEquals("42", actualWithApplicationNameResult.applicationName());
    assertEquals("42", actualWithApplicationNameResult.domainObjectId());
    assertEquals("42", actualWithApplicationNameResult.internalId());
    assertEquals("42", actualWithApplicationNameResult.orgObjectId());
    assertEquals("Domain Object Name", actualWithApplicationNameResult.domainObjectName());
    assertEquals("Org Object Name", actualWithApplicationNameResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithApplicationNameResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withDomainObjectId(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withDomainObjectId(String)}
   */
  @Test
  @DisplayName("Test withDomainObjectId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withDomainObjectId(String)"
  })
  void testWithDomainObjectId() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithDomainObjectIdResult =
        immutableBusinessSupportRow.withDomainObjectId("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithDomainObjectIdResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withDomainObjectId(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withDomainObjectId(String)}
   */
  @Test
  @DisplayName("Test withDomainObjectId(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withDomainObjectId(String)"
  })
  void testWithDomainObjectId_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithDomainObjectIdResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("domainObjectId")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withDomainObjectId("42");

    // Assert
    assertEquals("2020-03-01", actualWithDomainObjectIdResult.endDate());
    assertEquals("2020-03-01", actualWithDomainObjectIdResult.startDate());
    assertEquals("42", actualWithDomainObjectIdResult.applicationId());
    assertEquals("42", actualWithDomainObjectIdResult.domainObjectId());
    assertEquals("42", actualWithDomainObjectIdResult.internalId());
    assertEquals("42", actualWithDomainObjectIdResult.orgObjectId());
    assertEquals("Application Name", actualWithDomainObjectIdResult.applicationName());
    assertEquals("Domain Object Name", actualWithDomainObjectIdResult.domainObjectName());
    assertEquals("Org Object Name", actualWithDomainObjectIdResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithDomainObjectIdResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withDomainObjectName(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withDomainObjectName(String)}
   */
  @Test
  @DisplayName("Test withDomainObjectName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withDomainObjectName(String)"
  })
  void testWithDomainObjectName() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("42")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithDomainObjectNameResult =
        immutableBusinessSupportRow.withDomainObjectName("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithDomainObjectNameResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withDomainObjectName(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withDomainObjectName(String)}
   */
  @Test
  @DisplayName("Test withDomainObjectName(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withDomainObjectName(String)"
  })
  void testWithDomainObjectName_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithDomainObjectNameResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withDomainObjectName("42");

    // Assert
    assertEquals("2020-03-01", actualWithDomainObjectNameResult.endDate());
    assertEquals("2020-03-01", actualWithDomainObjectNameResult.startDate());
    assertEquals("42", actualWithDomainObjectNameResult.applicationId());
    assertEquals("42", actualWithDomainObjectNameResult.domainObjectId());
    assertEquals("42", actualWithDomainObjectNameResult.domainObjectName());
    assertEquals("42", actualWithDomainObjectNameResult.internalId());
    assertEquals("42", actualWithDomainObjectNameResult.orgObjectId());
    assertEquals("Application Name", actualWithDomainObjectNameResult.applicationName());
    assertEquals("Org Object Name", actualWithDomainObjectNameResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithDomainObjectNameResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withEndDate(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withEndDate(String)"})
  void testWithEndDate() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("42")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithEndDateResult =
        immutableBusinessSupportRow.withEndDate("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithEndDateResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withEndDate(String)}.
   *
   * <ul>
   *   <li>Then return startDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String); then return startDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withEndDate(String)"})
  void testWithEndDate_thenReturnStartDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithEndDateResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withEndDate("42");

    // Assert
    assertEquals("2020-03-01", actualWithEndDateResult.startDate());
    assertEquals("42", actualWithEndDateResult.applicationId());
    assertEquals("42", actualWithEndDateResult.domainObjectId());
    assertEquals("42", actualWithEndDateResult.endDate());
    assertEquals("42", actualWithEndDateResult.internalId());
    assertEquals("42", actualWithEndDateResult.orgObjectId());
    assertEquals("Application Name", actualWithEndDateResult.applicationName());
    assertEquals("Domain Object Name", actualWithEndDateResult.domainObjectName());
    assertEquals("Org Object Name", actualWithEndDateResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithEndDateResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withInternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withInternalId(String)}
   */
  @Test
  @DisplayName("Test withInternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withInternalId(String)"
  })
  void testWithInternalId() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithInternalIdResult =
        immutableBusinessSupportRow.withInternalId("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithInternalIdResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withInternalId(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withInternalId(String)}
   */
  @Test
  @DisplayName("Test withInternalId(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withInternalId(String)"
  })
  void testWithInternalId_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithInternalIdResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("internalId")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withInternalId("42");

    // Assert
    assertEquals("2020-03-01", actualWithInternalIdResult.endDate());
    assertEquals("2020-03-01", actualWithInternalIdResult.startDate());
    assertEquals("42", actualWithInternalIdResult.applicationId());
    assertEquals("42", actualWithInternalIdResult.domainObjectId());
    assertEquals("42", actualWithInternalIdResult.internalId());
    assertEquals("42", actualWithInternalIdResult.orgObjectId());
    assertEquals("Application Name", actualWithInternalIdResult.applicationName());
    assertEquals("Domain Object Name", actualWithInternalIdResult.domainObjectName());
    assertEquals("Org Object Name", actualWithInternalIdResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithInternalIdResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withOrgObjectId(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withOrgObjectId(String)}
   */
  @Test
  @DisplayName("Test withOrgObjectId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withOrgObjectId(String)"
  })
  void testWithOrgObjectId() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithOrgObjectIdResult =
        immutableBusinessSupportRow.withOrgObjectId("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithOrgObjectIdResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withOrgObjectId(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withOrgObjectId(String)}
   */
  @Test
  @DisplayName("Test withOrgObjectId(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withOrgObjectId(String)"
  })
  void testWithOrgObjectId_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithOrgObjectIdResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("Org Object Id")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withOrgObjectId("42");

    // Assert
    assertEquals("2020-03-01", actualWithOrgObjectIdResult.endDate());
    assertEquals("2020-03-01", actualWithOrgObjectIdResult.startDate());
    assertEquals("42", actualWithOrgObjectIdResult.applicationId());
    assertEquals("42", actualWithOrgObjectIdResult.domainObjectId());
    assertEquals("42", actualWithOrgObjectIdResult.internalId());
    assertEquals("42", actualWithOrgObjectIdResult.orgObjectId());
    assertEquals("Application Name", actualWithOrgObjectIdResult.applicationName());
    assertEquals("Domain Object Name", actualWithOrgObjectIdResult.domainObjectName());
    assertEquals("Org Object Name", actualWithOrgObjectIdResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithOrgObjectIdResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withOrgObjectName(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withOrgObjectName(String)}
   */
  @Test
  @DisplayName("Test withOrgObjectName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withOrgObjectName(String)"
  })
  void testWithOrgObjectName() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("42")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithOrgObjectNameResult =
        immutableBusinessSupportRow.withOrgObjectName("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithOrgObjectNameResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withOrgObjectName(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withOrgObjectName(String)}
   */
  @Test
  @DisplayName("Test withOrgObjectName(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withOrgObjectName(String)"
  })
  void testWithOrgObjectName_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithOrgObjectNameResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withOrgObjectName("42");

    // Assert
    assertEquals("2020-03-01", actualWithOrgObjectNameResult.endDate());
    assertEquals("2020-03-01", actualWithOrgObjectNameResult.startDate());
    assertEquals("42", actualWithOrgObjectNameResult.applicationId());
    assertEquals("42", actualWithOrgObjectNameResult.domainObjectId());
    assertEquals("42", actualWithOrgObjectNameResult.internalId());
    assertEquals("42", actualWithOrgObjectNameResult.orgObjectId());
    assertEquals("42", actualWithOrgObjectNameResult.orgObjectName());
    assertEquals("Application Name", actualWithOrgObjectNameResult.applicationName());
    assertEquals("Domain Object Name", actualWithOrgObjectNameResult.domainObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithOrgObjectNameResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withStartDate(String)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withStartDate(String)}
   */
  @Test
  @DisplayName("Test withStartDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withStartDate(String)"
  })
  void testWithStartDate() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("42")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithStartDateResult =
        immutableBusinessSupportRow.withStartDate("42");

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithStartDateResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withStartDate(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withStartDate(String)}
   */
  @Test
  @DisplayName("Test withStartDate(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withStartDate(String)"
  })
  void testWithStartDate_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithStartDateResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build()
            .withStartDate("42");

    // Assert
    assertEquals("2020-03-01", actualWithStartDateResult.endDate());
    assertEquals("42", actualWithStartDateResult.applicationId());
    assertEquals("42", actualWithStartDateResult.domainObjectId());
    assertEquals("42", actualWithStartDateResult.internalId());
    assertEquals("42", actualWithStartDateResult.orgObjectId());
    assertEquals("42", actualWithStartDateResult.startDate());
    assertEquals("Application Name", actualWithStartDateResult.applicationName());
    assertEquals("Domain Object Name", actualWithStartDateResult.domainObjectName());
    assertEquals("Org Object Name", actualWithStartDateResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithStartDateResult.status());
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withStatus(EntityLifecycleStatus)"
  })
  void testWithStatus() {
    // Arrange
    ImmutableBusinessSupportRow immutableBusinessSupportRow =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableBusinessSupportRow actualWithStatusResult =
        immutableBusinessSupportRow.withStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableBusinessSupportRow, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableBusinessSupportRow#withStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBusinessSupportRow#withStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(EntityLifecycleStatus); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBusinessSupportRow ImmutableBusinessSupportRow.withStatus(EntityLifecycleStatus)"
  })
  void testWithStatus_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableBusinessSupportRow actualWithStatusResult =
        ImmutableBusinessSupportRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .domainObjectId("42")
            .domainObjectName("Domain Object Name")
            .endDate("2020-03-01")
            .internalId("42")
            .orgObjectId("42")
            .orgObjectName("Org Object Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.PENDING)
            .build()
            .withStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("2020-03-01", actualWithStatusResult.endDate());
    assertEquals("2020-03-01", actualWithStatusResult.startDate());
    assertEquals("42", actualWithStatusResult.applicationId());
    assertEquals("42", actualWithStatusResult.domainObjectId());
    assertEquals("42", actualWithStatusResult.internalId());
    assertEquals("42", actualWithStatusResult.orgObjectId());
    assertEquals("Application Name", actualWithStatusResult.applicationName());
    assertEquals("Domain Object Name", actualWithStatusResult.domainObjectName());
    assertEquals("Org Object Name", actualWithStatusResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithStatusResult.status());
  }
}
