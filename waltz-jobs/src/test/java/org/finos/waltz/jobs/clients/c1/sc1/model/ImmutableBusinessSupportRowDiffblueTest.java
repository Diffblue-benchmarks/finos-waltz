package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableBusinessSupportRow.Builder;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBusinessSupportRowDiffblueTest {
  /**
   * Test {@link ImmutableBusinessSupportRow#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBusinessSupportRow#builder()}
   *   <li>{@link ImmutableBusinessSupportRow#endDate(String)}
   *   <li>{@link ImmutableBusinessSupportRow#orgObjectId(String)}
   *   <li>{@link ImmutableBusinessSupportRow#orgObjectName(String)}
   *   <li>{@link ImmutableBusinessSupportRow#startDate(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBusinessSupportRow Builder.build()", "Builder Builder.endDate(String)",
      "Builder Builder.orgObjectId(String)", "Builder Builder.orgObjectName(String)",
      "Builder Builder.startDate(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualOrgObjectNameResult = ImmutableBusinessSupportRow.builder()
        .endDate("2020-03-01")
        .orgObjectId("42")
        .orgObjectName("Org Object Name");

    // Assert
    assertSame(actualOrgObjectNameResult, actualOrgObjectNameResult.startDate("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#applicationId(String)}.
   * <p>
   * Method under test: {@link Builder#applicationId(String)}
   */
  @Test
  @DisplayName("Test Builder applicationId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationId(String)"})
  void testBuilderApplicationId() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationId("42"));
  }

  /**
   * Test Builder {@link Builder#applicationName(String)}.
   * <p>
   * Method under test: {@link Builder#applicationName(String)}
   */
  @Test
  @DisplayName("Test Builder applicationName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationName(String)"})
  void testBuilderApplicationName() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationName("Application Name"));
  }

  /**
   * Test Builder {@link Builder#domainObjectId(String)}.
   * <p>
   * Method under test: {@link Builder#domainObjectId(String)}
   */
  @Test
  @DisplayName("Test Builder domainObjectId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.domainObjectId(String)"})
  void testBuilderDomainObjectId() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainObjectId("42"));
  }

  /**
   * Test Builder {@link Builder#domainObjectName(String)}.
   * <p>
   * Method under test: {@link Builder#domainObjectName(String)}
   */
  @Test
  @DisplayName("Test Builder domainObjectName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.domainObjectName(String)"})
  void testBuilderDomainObjectName() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainObjectName("Domain Object Name"));
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   * <ul>
   *   <li>Given {@code Org Object Name}.</li>
   *   <li>Then builder build endDate is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow); given 'Org Object Name'; then builder build endDate is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom_givenOrgObjectName_thenBuilderBuildEndDateIs20200301() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    BusinessSupportRow instance = mock(BusinessSupportRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.orgObjectId()).thenReturn("42");
    when(instance.orgObjectName()).thenReturn("Org Object Name");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");
    when(instance.domainObjectName()).thenReturn("Domain Object Name");
    when(instance.domainObjectId()).thenReturn("42");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.internalId()).thenReturn("42");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).domainObjectId();
    verify(instance).domainObjectName();
    verify(instance).endDate();
    verify(instance).internalId();
    verify(instance).orgObjectId();
    verify(instance).orgObjectName();
    verify(instance).startDate();
    verify(instance).status();
    ImmutableBusinessSupportRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("42", buildResult.orgObjectId());
    assertEquals("Org Object Name", buildResult.orgObjectName());
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   * <ul>
   *   <li>Then builder build endDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow); then builder build endDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom_thenBuilderBuildEndDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    BusinessSupportRow instance = mock(BusinessSupportRow.class);
    when(instance.endDate()).thenReturn(null);
    when(instance.orgObjectId()).thenReturn("42");
    when(instance.orgObjectName()).thenReturn("Org Object Name");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");
    when(instance.domainObjectName()).thenReturn("Domain Object Name");
    when(instance.domainObjectId()).thenReturn("42");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.internalId()).thenReturn("42");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).domainObjectId();
    verify(instance).domainObjectName();
    verify(instance).endDate();
    verify(instance).internalId();
    verify(instance).orgObjectId();
    verify(instance).orgObjectName();
    verify(instance).startDate();
    verify(instance).status();
    ImmutableBusinessSupportRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("42", buildResult.orgObjectId());
    assertEquals("Org Object Name", buildResult.orgObjectName());
    assertNull(buildResult.endDate());
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   * <ul>
   *   <li>Then builder build orgObjectId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow); then builder build orgObjectId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom_thenBuilderBuildOrgObjectIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    BusinessSupportRow instance = mock(BusinessSupportRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.orgObjectId()).thenReturn(null);
    when(instance.orgObjectName()).thenReturn("Org Object Name");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");
    when(instance.domainObjectName()).thenReturn("Domain Object Name");
    when(instance.domainObjectId()).thenReturn("42");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.internalId()).thenReturn("42");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).domainObjectId();
    verify(instance).domainObjectName();
    verify(instance).endDate();
    verify(instance).internalId();
    verify(instance).orgObjectId();
    verify(instance).orgObjectName();
    verify(instance).startDate();
    verify(instance).status();
    ImmutableBusinessSupportRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("Org Object Name", buildResult.orgObjectName());
    assertNull(buildResult.orgObjectId());
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   * <ul>
   *   <li>Then builder build orgObjectName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow); then builder build orgObjectName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom_thenBuilderBuildOrgObjectNameIsNull() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    BusinessSupportRow instance = mock(BusinessSupportRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.orgObjectId()).thenReturn("42");
    when(instance.orgObjectName()).thenReturn(null);
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");
    when(instance.domainObjectName()).thenReturn("Domain Object Name");
    when(instance.domainObjectId()).thenReturn("42");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.internalId()).thenReturn("42");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).domainObjectId();
    verify(instance).domainObjectName();
    verify(instance).endDate();
    verify(instance).internalId();
    verify(instance).orgObjectId();
    verify(instance).orgObjectName();
    verify(instance).startDate();
    verify(instance).status();
    ImmutableBusinessSupportRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("42", buildResult.orgObjectId());
    assertNull(buildResult.orgObjectName());
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   * <ul>
   *   <li>Then builder build startDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow); then builder build startDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom_thenBuilderBuildStartDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    BusinessSupportRow instance = mock(BusinessSupportRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.orgObjectId()).thenReturn("42");
    when(instance.orgObjectName()).thenReturn("Org Object Name");
    when(instance.startDate()).thenReturn(null);
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");
    when(instance.domainObjectName()).thenReturn("Domain Object Name");
    when(instance.domainObjectId()).thenReturn("42");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.internalId()).thenReturn("42");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).domainObjectId();
    verify(instance).domainObjectName();
    verify(instance).endDate();
    verify(instance).internalId();
    verify(instance).orgObjectId();
    verify(instance).orgObjectName();
    verify(instance).startDate();
    verify(instance).status();
    ImmutableBusinessSupportRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("42", buildResult.orgObjectId());
    assertEquals("Org Object Name", buildResult.orgObjectName());
    assertNull(buildResult.startDate());
  }

  /**
   * Test Builder {@link Builder#from(BusinessSupportRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BusinessSupportRow)}
   */
  @Test
  @DisplayName("Test Builder from(BusinessSupportRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BusinessSupportRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();
    BusinessSupportRow instance = mock(BusinessSupportRow.class);
    when(instance.orgObjectId()).thenThrow(new IllegalStateException("instance"));
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");
    when(instance.domainObjectName()).thenReturn("Domain Object Name");
    when(instance.domainObjectId()).thenReturn("42");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.internalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).domainObjectId();
    verify(instance).domainObjectName();
    verify(instance).internalId();
    verify(instance).orgObjectId();
    verify(instance).status();
  }

  /**
   * Test Builder {@link Builder#internalId(String)}.
   * <p>
   * Method under test: {@link Builder#internalId(String)}
   */
  @Test
  @DisplayName("Test Builder internalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.internalId(String)"})
  void testBuilderInternalId() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.internalId("42"));
  }

  /**
   * Test Builder {@link Builder#status(EntityLifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#status(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(EntityLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(EntityLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(EntityLifecycleStatus.ACTIVE));
  }
}
