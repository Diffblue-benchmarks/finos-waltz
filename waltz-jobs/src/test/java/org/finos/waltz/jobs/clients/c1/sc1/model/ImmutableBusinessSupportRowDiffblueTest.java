package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.Test;

class ImmutableBusinessSupportRowDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableBusinessSupportRow.Builder actualOrgObjectNameResult = ImmutableBusinessSupportRow.builder()
        .endDate("2020-03-01")
        .orgObjectId("42")
        .orgObjectName("Org Object Name");

    // Assert
    assertSame(actualOrgObjectNameResult, actualOrgObjectNameResult.startDate("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#applicationId(String)}
   */
  @Test
  void testBuilderApplicationId() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#applicationName(String)}
   */
  @Test
  void testBuilderApplicationName() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationName("Application Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#domainObjectId(String)}
   */
  @Test
  void testBuilderDomainObjectId() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainObjectId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#domainObjectName(String)}
   */
  @Test
  void testBuilderDomainObjectName() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainObjectName("Domain Object Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#from(BusinessSupportRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();
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
    ImmutableBusinessSupportRow.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.internalId());
    assertEquals("42", buildResult.orgObjectId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Domain Object Name", buildResult.domainObjectName());
    assertEquals("Org Object Name", buildResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#from(BusinessSupportRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();
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
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#from(BusinessSupportRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();
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
    ImmutableBusinessSupportRow.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.internalId());
    assertEquals("42", buildResult.orgObjectId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Domain Object Name", buildResult.domainObjectName());
    assertEquals("Org Object Name", buildResult.orgObjectName());
    assertNull(buildResult.endDate());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#from(BusinessSupportRow)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();
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
    ImmutableBusinessSupportRow.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.internalId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Domain Object Name", buildResult.domainObjectName());
    assertEquals("Org Object Name", buildResult.orgObjectName());
    assertNull(buildResult.orgObjectId());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#from(BusinessSupportRow)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();
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
    ImmutableBusinessSupportRow.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.internalId());
    assertEquals("42", buildResult.orgObjectId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Domain Object Name", buildResult.domainObjectName());
    assertNull(buildResult.orgObjectName());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#from(BusinessSupportRow)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();
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
    ImmutableBusinessSupportRow.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.internalId());
    assertEquals("42", buildResult.orgObjectId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Domain Object Name", buildResult.domainObjectName());
    assertEquals("Org Object Name", buildResult.orgObjectName());
    assertNull(buildResult.startDate());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#internalId(String)}
   */
  @Test
  void testBuilderInternalId() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.internalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow.Builder#status(EntityLifecycleStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableBusinessSupportRow.Builder builderResult = ImmutableBusinessSupportRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableBusinessSupportRow#copyOf(BusinessSupportRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableBusinessSupportRow actualCopyOfResult = ImmutableBusinessSupportRow.copyOf(instance);

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
}
