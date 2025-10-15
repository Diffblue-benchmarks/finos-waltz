package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableDomainRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDomainRowDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#crossReference(String)}
   *   <li>{@link Builder#parentDomainObjectId(String)}
   *   <li>{@link Builder#parentExtId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDomainRow Builder.build()",
    "Builder Builder.crossReference(String)",
    "Builder Builder.parentDomainObjectId(String)",
    "Builder Builder.parentExtId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableDomainRow actualImmutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableDomainRow.domainObjectId());
    assertEquals("42", actualImmutableDomainRow.parentDomainObjectId());
    assertEquals("42", actualImmutableDomainRow.parentExtId());
    assertEquals("Cross Reference", actualImmutableDomainRow.crossReference());
    assertEquals("Domain Name", actualImmutableDomainRow.domainName());
  }

  /**
   * Test Builder {@link Builder#domainName(String)}.
   *
   * <ul>
   *   <li>When {@code Domain Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#domainName(String)}
   */
  @Test
  @DisplayName("Test Builder domainName(String); when 'Domain Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.domainName(String)"})
  void testBuilderDomainName_whenDomainName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();

    // Act
    Builder actualDomainNameResult = builderResult.domainName("Domain Name");

    // Assert
    assertSame(builderResult, actualDomainNameResult);
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
    Builder builderResult = ImmutableDomainRow.builder();

    // Act
    Builder actualDomainObjectIdResult = builderResult.domainObjectId("42");

    // Assert
    assertSame(builderResult, actualDomainObjectIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DomainRow)}.
   *
   * <p>Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    ImmutableDomainRow instance =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDomainRow actualImmutableDomainRow = builderResult.build();
    assertEquals(instance, actualImmutableDomainRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DomainRow)}.
   *
   * <p>Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    ImmutableDomainRow instance =
        ImmutableDomainRow.builder()
            .crossReference(null)
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDomainRow actualImmutableDomainRow = builderResult.build();
    assertEquals(instance, actualImmutableDomainRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DomainRow)}.
   *
   * <p>Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    ImmutableDomainRow instance =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId(null)
            .parentExtId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDomainRow actualImmutableDomainRow = builderResult.build();
    assertEquals(instance, actualImmutableDomainRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DomainRow)}.
   *
   * <p>Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    ImmutableDomainRow instance =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDomainRow actualImmutableDomainRow = builderResult.build();
    assertEquals(instance, actualImmutableDomainRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableDomainRow#copyOf(DomainRow)}.
   *
   * <ul>
   *   <li>Then return domainObjectId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#copyOf(DomainRow)}
   */
  @Test
  @DisplayName("Test copyOf(DomainRow); then return domainObjectId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.copyOf(DomainRow)"})
  void testCopyOf_thenReturnDomainObjectIdIs42() {
    // Arrange
    ImmutableDomainRow instance =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    ImmutableDomainRow actualCopyOfResult = ImmutableDomainRow.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.domainObjectId());
    assertEquals("42", actualCopyOfResult.parentDomainObjectId());
    assertEquals("42", actualCopyOfResult.parentExtId());
    assertEquals("Cross Reference", actualCopyOfResult.crossReference());
    assertEquals("Domain Name", actualCopyOfResult.domainName());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}, and {@link ImmutableDomainRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDomainRow#equals(Object)}
   *   <li>{@link ImmutableDomainRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();
    ImmutableDomainRow immutableDomainRow2 =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act and Assert
    assertEquals(immutableDomainRow, immutableDomainRow2);
    assertEquals(immutableDomainRow.hashCode(), immutableDomainRow2.hashCode());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}, and {@link ImmutableDomainRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDomainRow#equals(Object)}
   *   <li>{@link ImmutableDomainRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act and Assert
    assertEquals(immutableDomainRow, immutableDomainRow);
    int expectedHashCodeResult = immutableDomainRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableDomainRow.hashCode());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("42")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDomainRow,
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("42")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDomainRow,
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("Domain Name")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDomainRow,
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("Domain Name")
            .parentExtId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDomainRow,
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("Domain Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDomainRow,
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build());
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDomainRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDomainRow.equals(Object)",
    "int ImmutableDomainRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build(),
        "Different type to ImmutableDomainRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDomainRow#toString()}
   *   <li>{@link ImmutableDomainRow#crossReference()}
   *   <li>{@link ImmutableDomainRow#domainName()}
   *   <li>{@link ImmutableDomainRow#domainObjectId()}
   *   <li>{@link ImmutableDomainRow#parentDomainObjectId()}
   *   <li>{@link ImmutableDomainRow#parentExtId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableDomainRow.crossReference()",
    "String ImmutableDomainRow.domainName()",
    "String ImmutableDomainRow.domainObjectId()",
    "String ImmutableDomainRow.parentDomainObjectId()",
    "String ImmutableDomainRow.parentExtId()",
    "String ImmutableDomainRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    String actualToStringResult = immutableDomainRow.toString();
    String actualCrossReferenceResult = immutableDomainRow.crossReference();
    String actualDomainNameResult = immutableDomainRow.domainName();
    String actualDomainObjectIdResult = immutableDomainRow.domainObjectId();
    String actualParentDomainObjectIdResult = immutableDomainRow.parentDomainObjectId();

    // Assert
    assertEquals("42", actualDomainObjectIdResult);
    assertEquals("42", actualParentDomainObjectIdResult);
    assertEquals("42", immutableDomainRow.parentExtId());
    assertEquals("Cross Reference", actualCrossReferenceResult);
    assertEquals("Domain Name", actualDomainNameResult);
    assertEquals(
        "DomainRow{domainObjectId=42, domainName=Domain Name, parentDomainObjectId=42, parentExtId=42,"
            + " crossReference=Cross Reference}",
        actualToStringResult);
  }

  /**
   * Test {@link ImmutableDomainRow#withCrossReference(String)}.
   *
   * <p>Method under test: {@link ImmutableDomainRow#withCrossReference(String)}
   */
  @Test
  @DisplayName("Test withCrossReference(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withCrossReference(String)"})
  void testWithCrossReference() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("42")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    ImmutableDomainRow actualWithCrossReferenceResult = immutableDomainRow.withCrossReference("42");

    // Assert
    assertSame(immutableDomainRow, actualWithCrossReferenceResult);
  }

  /**
   * Test {@link ImmutableDomainRow#withCrossReference(String)}.
   *
   * <ul>
   *   <li>Then return crossReference is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#withCrossReference(String)}
   */
  @Test
  @DisplayName("Test withCrossReference(String); then return crossReference is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withCrossReference(String)"})
  void testWithCrossReference_thenReturnCrossReferenceIs42() {
    // Arrange and Act
    ImmutableDomainRow actualWithCrossReferenceResult =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build()
            .withCrossReference("42");

    // Assert
    assertEquals("42", actualWithCrossReferenceResult.crossReference());
    assertEquals("42", actualWithCrossReferenceResult.domainObjectId());
    assertEquals("42", actualWithCrossReferenceResult.parentDomainObjectId());
    assertEquals("42", actualWithCrossReferenceResult.parentExtId());
    assertEquals("Domain Name", actualWithCrossReferenceResult.domainName());
  }

  /**
   * Test {@link ImmutableDomainRow#withDomainName(String)}.
   *
   * <p>Method under test: {@link ImmutableDomainRow#withDomainName(String)}
   */
  @Test
  @DisplayName("Test withDomainName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withDomainName(String)"})
  void testWithDomainName() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("42")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    ImmutableDomainRow actualWithDomainNameResult = immutableDomainRow.withDomainName("42");

    // Assert
    assertSame(immutableDomainRow, actualWithDomainNameResult);
  }

  /**
   * Test {@link ImmutableDomainRow#withDomainName(String)}.
   *
   * <ul>
   *   <li>Then return domainName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#withDomainName(String)}
   */
  @Test
  @DisplayName("Test withDomainName(String); then return domainName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withDomainName(String)"})
  void testWithDomainName_thenReturnDomainNameIs42() {
    // Arrange and Act
    ImmutableDomainRow actualWithDomainNameResult =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build()
            .withDomainName("42");

    // Assert
    assertEquals("42", actualWithDomainNameResult.domainName());
    assertEquals("42", actualWithDomainNameResult.domainObjectId());
    assertEquals("42", actualWithDomainNameResult.parentDomainObjectId());
    assertEquals("42", actualWithDomainNameResult.parentExtId());
    assertEquals("Cross Reference", actualWithDomainNameResult.crossReference());
  }

  /**
   * Test {@link ImmutableDomainRow#withDomainObjectId(String)}.
   *
   * <p>Method under test: {@link ImmutableDomainRow#withDomainObjectId(String)}
   */
  @Test
  @DisplayName("Test withDomainObjectId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withDomainObjectId(String)"})
  void testWithDomainObjectId() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    ImmutableDomainRow actualWithDomainObjectIdResult = immutableDomainRow.withDomainObjectId("42");

    // Assert
    assertSame(immutableDomainRow, actualWithDomainObjectIdResult);
  }

  /**
   * Test {@link ImmutableDomainRow#withDomainObjectId(String)}.
   *
   * <ul>
   *   <li>Then return domainObjectId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#withDomainObjectId(String)}
   */
  @Test
  @DisplayName("Test withDomainObjectId(String); then return domainObjectId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withDomainObjectId(String)"})
  void testWithDomainObjectId_thenReturnDomainObjectIdIs42() {
    // Arrange and Act
    ImmutableDomainRow actualWithDomainObjectIdResult =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("domainObjectId")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build()
            .withDomainObjectId("42");

    // Assert
    assertEquals("42", actualWithDomainObjectIdResult.domainObjectId());
    assertEquals("42", actualWithDomainObjectIdResult.parentDomainObjectId());
    assertEquals("42", actualWithDomainObjectIdResult.parentExtId());
    assertEquals("Cross Reference", actualWithDomainObjectIdResult.crossReference());
    assertEquals("Domain Name", actualWithDomainObjectIdResult.domainName());
  }

  /**
   * Test {@link ImmutableDomainRow#withParentDomainObjectId(String)}.
   *
   * <p>Method under test: {@link ImmutableDomainRow#withParentDomainObjectId(String)}
   */
  @Test
  @DisplayName("Test withParentDomainObjectId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withParentDomainObjectId(String)"})
  void testWithParentDomainObjectId() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    ImmutableDomainRow actualWithParentDomainObjectIdResult =
        immutableDomainRow.withParentDomainObjectId("42");

    // Assert
    assertSame(immutableDomainRow, actualWithParentDomainObjectIdResult);
  }

  /**
   * Test {@link ImmutableDomainRow#withParentDomainObjectId(String)}.
   *
   * <ul>
   *   <li>Then return domainObjectId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#withParentDomainObjectId(String)}
   */
  @Test
  @DisplayName("Test withParentDomainObjectId(String); then return domainObjectId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withParentDomainObjectId(String)"})
  void testWithParentDomainObjectId_thenReturnDomainObjectIdIs42() {
    // Arrange and Act
    ImmutableDomainRow actualWithParentDomainObjectIdResult =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("Parent Domain Object Id")
            .parentExtId("42")
            .build()
            .withParentDomainObjectId("42");

    // Assert
    assertEquals("42", actualWithParentDomainObjectIdResult.domainObjectId());
    assertEquals("42", actualWithParentDomainObjectIdResult.parentDomainObjectId());
    assertEquals("42", actualWithParentDomainObjectIdResult.parentExtId());
    assertEquals("Cross Reference", actualWithParentDomainObjectIdResult.crossReference());
    assertEquals("Domain Name", actualWithParentDomainObjectIdResult.domainName());
  }

  /**
   * Test {@link ImmutableDomainRow#withParentExtId(String)}.
   *
   * <p>Method under test: {@link ImmutableDomainRow#withParentExtId(String)}
   */
  @Test
  @DisplayName("Test withParentExtId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withParentExtId(String)"})
  void testWithParentExtId() {
    // Arrange
    ImmutableDomainRow immutableDomainRow =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("42")
            .build();

    // Act
    ImmutableDomainRow actualWithParentExtIdResult = immutableDomainRow.withParentExtId("42");

    // Assert
    assertSame(immutableDomainRow, actualWithParentExtIdResult);
  }

  /**
   * Test {@link ImmutableDomainRow#withParentExtId(String)}.
   *
   * <ul>
   *   <li>Then return domainObjectId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDomainRow#withParentExtId(String)}
   */
  @Test
  @DisplayName("Test withParentExtId(String); then return domainObjectId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDomainRow ImmutableDomainRow.withParentExtId(String)"})
  void testWithParentExtId_thenReturnDomainObjectIdIs42() {
    // Arrange and Act
    ImmutableDomainRow actualWithParentExtIdResult =
        ImmutableDomainRow.builder()
            .crossReference("Cross Reference")
            .domainName("Domain Name")
            .domainObjectId("42")
            .parentDomainObjectId("42")
            .parentExtId("Parent Ext Id")
            .build()
            .withParentExtId("42");

    // Assert
    assertEquals("42", actualWithParentExtIdResult.domainObjectId());
    assertEquals("42", actualWithParentExtIdResult.parentDomainObjectId());
    assertEquals("42", actualWithParentExtIdResult.parentExtId());
    assertEquals("Cross Reference", actualWithParentExtIdResult.crossReference());
    assertEquals("Domain Name", actualWithParentExtIdResult.domainName());
  }
}
