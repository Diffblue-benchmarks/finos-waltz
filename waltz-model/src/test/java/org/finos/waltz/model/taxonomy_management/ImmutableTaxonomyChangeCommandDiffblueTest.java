package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangeCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeCommand#builder()}
   *   <li>{@link ImmutableTaxonomyChangeCommand#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableTaxonomyChangeCommand#lastUpdatedAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableTaxonomyChangeCommand#status(TaxonomyChangeLifecycleStatus)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableTaxonomyChangeCommand.Builder actualBuilderResult = ImmutableTaxonomyChangeCommand.builder();
    ImmutableTaxonomyChangeCommand.Builder actualIdResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableTaxonomyChangeCommand.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableTaxonomyChangeCommand.Builder actualLastUpdatedAtResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    ImmutableTaxonomyChangeCommand.Builder actualParamsResult = actualLastUpdatedAtResult.params(new HashMap<>());

    // Assert
    assertSame(actualParamsResult, actualParamsResult.status(TaxonomyChangeLifecycleStatus.DRAFT));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#changeDomain(EntityReference)}
   */
  @Test
  void testBuilderChangeDomain() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeDomain(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#changeType(TaxonomyChangeType)}
   */
  @Test
  void testBuilderChangeType() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeType(TaxonomyChangeType.ADD_PEER));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#changeType(TaxonomyChangeType)}
   */
  @Test
  void testBuilderChangeType2() {
    // Arrange
    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("foo", mock(BiFunction.class));
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putAllParams(entries);

    // Act and Assert
    assertSame(builderResult, builderResult.changeType(TaxonomyChangeType.ADD_PEER));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy2() {
    // Arrange
    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("foo", mock(BiFunction.class));
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putAllParams(entries);

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTaxonomyChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableTaxonomyChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableTaxonomyChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableTaxonomyChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.changeDomain()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(new HashMap<>());
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTaxonomyChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    ImmutableTaxonomyChangeCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, buildResult.changeType());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams("instance", "42");
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(new HashMap<>());
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTaxonomyChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    ImmutableTaxonomyChangeCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    Map<String, String> paramsResult = buildResult.params();
    assertEquals(1, paramsResult.size());
    assertEquals("42", paramsResult.get("instance"));
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, buildResult.changeType());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(stringStringMap);
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTaxonomyChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    ImmutableTaxonomyChangeCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    Map<String, String> paramsResult = buildResult.params();
    assertEquals(1, paramsResult.size());
    assertEquals("instance", paramsResult.get("instance"));
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, buildResult.changeType());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("foo", mock(BiFunction.class));
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putAllParams(entries);

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("foo", mock(BiFunction.class));
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putAllParams(entries);
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy2() {
    // Arrange
    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("foo", mock(BiFunction.class));
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putAllParams(entries);

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Builder#params(Map)}
   */
  @Test
  void testBuilderParams() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.params(new HashMap<>()));
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Builder#params(Map)}
   */
  @Test
  void testBuilderParams2() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.params(null);

    // Act and Assert
    assertSame(builderResult, builderResult.params(null));
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Builder#params(Map)}
   */
  @Test
  void testBuilderParams3() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.params(entries));
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Builder#params(Map)}
   */
  @Test
  void testBuilderParams4() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("params key", mock(BiFunction.class));
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.params(entries));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#primaryReference(EntityReference)}
   */
  @Test
  void testBuilderPrimaryReference() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#putAllParams(Map)}
   */
  @Test
  void testBuilderPutAllParams() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllParams(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#putAllParams(Map)}
   */
  @Test
  void testBuilderPutAllParams2() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.params(new HashMap<>());

    // Act and Assert
    assertSame(builderResult, builderResult.putAllParams(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#putAllParams(Map)}
   */
  @Test
  void testBuilderPutAllParams3() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.putAllParams(entries));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#putAllParams(Map)}
   */
  @Test
  void testBuilderPutAllParams4() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.computeIfPresent("params key", mock(BiFunction.class));
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.putAllParams(entries));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#putParams(String, String)}
   */
  @Test
  void testBuilderPutParams() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putParams("Key", "42"));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#putParams(Map.Entry)}
   */
  @Test
  void testBuilderPutParams2() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putParams(new AbstractMap.SimpleEntry<>("foo", "foo")));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Builder#putParams(Map.Entry)}
   */
  @Test
  void testBuilderPutParams3() {
    // Arrange
    ImmutableTaxonomyChangeCommand.Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams("params key", "42");

    // Act and Assert
    assertSame(builderResult, builderResult.putParams(new AbstractMap.SimpleEntry<>("foo", "foo")));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand#copyOf(TaxonomyChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(new HashMap<>());
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());

    // Act
    ImmutableTaxonomyChangeCommand actualCopyOfResult = ImmutableTaxonomyChangeCommand.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualCopyOfResult.changeType());
    assertTrue(actualCopyOfResult.params().isEmpty());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand#copyOf(TaxonomyChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(stringStringMap);
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());

    // Act
    ImmutableTaxonomyChangeCommand actualCopyOfResult = ImmutableTaxonomyChangeCommand.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    Map<String, String> paramsResult = actualCopyOfResult.params();
    assertEquals(1, paramsResult.size());
    assertEquals("instance", paramsResult.get("instance"));
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualCopyOfResult.changeType());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand#copyOf(TaxonomyChangeCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("createdAt", "createdAt");
    stringStringMap.put("instance", "instance");
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(stringStringMap);
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());

    // Act
    ImmutableTaxonomyChangeCommand actualCopyOfResult = ImmutableTaxonomyChangeCommand.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualCopyOfResult.changeType());
    assertEquals(stringStringMap, actualCopyOfResult.params());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Json#changeDomain()}
   */
  @Test
  void testJsonChangeDomain() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeCommand.Json()).changeDomain());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Json#changeType()}
   */
  @Test
  void testJsonChangeType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeCommand.Json()).changeType());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeCommand.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeCommand.Json()).createdBy());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeCommand.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableTaxonomyChangeCommand.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableTaxonomyChangeCommand.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableTaxonomyChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableTaxonomyChangeCommand.Json actualJson = new ImmutableTaxonomyChangeCommand.Json();

    // Assert
    assertNull(actualJson.createdBy);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.params);
    assertNull(actualJson.changeDomain);
    assertNull(actualJson.primaryReference);
    assertNull(actualJson.status);
    assertNull(actualJson.changeType);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Json#params()}
   */
  @Test
  void testJsonParams() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeCommand.Json()).params());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeCommand.Json#primaryReference()}
   */
  @Test
  void testJsonPrimaryReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableTaxonomyChangeCommand.Json()).primaryReference());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeCommand.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeCommand.Json()).status());
  }
}
